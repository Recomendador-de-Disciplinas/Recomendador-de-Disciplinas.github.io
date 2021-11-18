export function processGraphData(rawData) {
  const disciplinesIdInNodesList = new Map();
  const data = {
    nodes: [],
    links: [],
  };

  rawData.forEach((discipline) => {
    const { code, name, url } = discipline;
    const requisitesByCourse = discipline.requisites;
    const requisites = requisitesByCourse[0]?.requisites;
    let idInNodeList = data.nodes.length + 1;

    data.nodes.push({
      id: idInNodeList,
      name: `${code} - ${name}`,
      code,
      url,
    });

    requisites?.forEach((requisite) => {
      const discipline = requisite.discipline;
      const [code, _] = discipline.split('-').map((el) => el.trim());
      let requisiteIdInNodeList;

      if (!disciplinesIdInNodesList.has(code)) {
        requisiteIdInNodeList = data.nodes.length + 1;
        disciplinesIdInNodesList.set(code, requisiteIdInNodeList);

        data.nodes.push({
          id: requisiteIdInNodeList,
          name: discipline,
          code,
          url: null,
        });
      } else {
        requisiteIdInNodeList = disciplinesIdInNodesList.get(code);
      }

      data.links.push({
        source: requisiteIdInNodeList,
        target: idInNodeList,
      });
    });
  });
  return data;
}
