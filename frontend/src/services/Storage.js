export function getDataFromStorage(storage) {
  return {
    name: JSON.parse(storage.getItem('name')) || '',
    disciplines: JSON.parse(storage.getItem('disciplines')) || [],
    departments: JSON.parse(storage.getItem('departments')) || [],
    keywords: JSON.parse(storage.getItem('keywords')) || [],
    courseCode: JSON.parse(storage.getItem('courseCode')) || '',
  };
}

export function getComputedDataFromStorage(storage) {
  return {
    name: JSON.parse(storage.getItem('name')) || '',
    keywords: JSON.parse(storage.getItem('keywords')) || [],
    courseCode: JSON.parse(storage.getItem('courseCode')) || '',
    disciplines:
      getComputedObjects(JSON.parse(storage.getItem('disciplines'))) || [],
    departments:
      getComputedObjects(JSON.parse(storage.getItem('departments'))) || [],
  };
}

export function saveDataInStorage(storage, payload) {
  const { userData, backendData } = payload;

  const { name, courseCode, disciplines, departments, keywords } = userData;
  const { allDepartments, allDisciplines } = backendData;

  storage.clear();

  const selectedDepartments = getFullObject(allDepartments, departments);
  const selectedDisciplines = getFullObject(allDisciplines, disciplines);
  const info = {
    name,
    courseCode,
    disciplines: selectedDisciplines,
    departments: selectedDepartments,
    keywords,
  };

  Object.keys(info).forEach((field) => {
    storage.setItem(field, JSON.stringify(info[field]));
  });
}

function getComputedObjects(objects) {
  return objects?.map((obj) => `${obj.code} - ${obj.name}`);
}

function getFullObject(allObjects, selecteds) {
  return selecteds.map((selected) =>
    allObjects.find(({ code }) => {
      const [inputCode] = selected.split('-');
      return inputCode.trim() == code;
    })
  );
}
