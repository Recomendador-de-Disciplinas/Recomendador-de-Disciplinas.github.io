export default class Form {
  static validateFields(payload) {
    const { name, departments, keywords } = payload;
    const errors = [];

    if (!name.trim()) errors.push('É necessário informar seu nome');

    if (departments.length === 0)
      errors.push(
        'É necessário informar ao menos um departamento de interesse'
      );
    if (keywords.length === 0)
      errors.push('É necessário informar ao menos um tópico de interesse');

    return {
      isValid: errors.length === 0,
      errors,
    };
  }

  static saveClientSide(storage, info, allDepartments, allDisciplines) {
    const { isValid, errors } = this.validateFields(info);

    if (!isValid) return errors;

    const { name, disciplines, departments, keywords } = info;

    storage.clear();

    const selectedDepartments = departments.map((department) =>
      allDepartments.find(({ code }) => {
        const [inputCode, _] = department.split('-');
        return inputCode.trim() == code;
      })
    );

    const selectedDisciplines = disciplines.map((discipline) =>
      allDisciplines.find(({ code }) => {
        const [inputCode, _] = discipline.split('-');
        return inputCode.trim() == code;
      })
    );

    info = {
      name,
      disciplines: selectedDisciplines,
      departments: selectedDepartments,
      keywords,
    };

    Object.keys(info).forEach((field) => {
      storage.setItem(field, JSON.stringify(info[field]));
    });

    return [];
  }
}
