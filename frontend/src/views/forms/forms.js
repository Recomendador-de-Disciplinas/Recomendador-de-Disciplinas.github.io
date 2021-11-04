export function saveClientSide(
  storage,
  { name, disciplines, departments, topics },
  allDepartments,
  allDisciplines
) {
  const selectedDepartments = departments.map((department) =>
    allDepartments.find(({ code }) => department.split(' ')[0] === code)
  );

  const selectedDisciplines = disciplines.map((discipline) =>
    allDisciplines.find(({ code }) => discipline === code)
  );

  const info = {
    name,
    disciplines: selectedDisciplines,
    departments: selectedDepartments,
    topics,
  };

  Object.keys(info).forEach((field) => {
    storage.setItem(field, JSON.stringify(info[field]));
  });
}
