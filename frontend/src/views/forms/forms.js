export default class Form {
  static validateFields(payload) {
    const { name, disciplines, departments, topics } = payload;
    const errors = [];

    if (!name.trim()) errors.push('É necessário informar seu nome');
    if (disciplines.length === 0)
      errors.push('É necessário informar pelo menos uma disciplina já cursada');
    if (departments.length === 0)
      errors.push(
        'É necessário informar ao menos um departamento de interesse'
      );
    if (topics.length === 0)
      errors.push('É necessário informar ao menos um tópico de interesse');

    return {
      isValid: errors.length === 0,
      errors,
    };
  }

  static saveClientSide(storage, info, allDepartments, allDisciplines) {
    const { isValid, errors } = this.validateFields(info);

    if (!isValid) return errors;

    const { name, disciplines, departments, topics } = info;

    storage.clear();

    const selectedDepartments = departments.map((department) =>
      allDepartments.find(({ code }) => department.split(' ')[0] === code)
    );

    const selectedDisciplines = disciplines.map((discipline) =>
      allDisciplines.find(({ code }) => discipline === code)
    );

    info = {
      name,
      disciplines: selectedDisciplines,
      departments: selectedDepartments,
      topics,
    };

    Object.keys(info).forEach((field) => {
      storage.setItem(field, JSON.stringify(info[field]));
    });

    return undefined;
  }
}
