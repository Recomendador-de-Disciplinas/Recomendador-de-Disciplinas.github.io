export default class Form {
  constructor(allCoursesCode, allDepartments, allDisciplines) {
    this.allCoursesCode = allCoursesCode;
    this.allDepartments = allDepartments;
    this.allDisciplines = allDisciplines;
  }

  validateFields(payload) {
    const { name, courseCode, departments, keywords } = payload;
    const errors = [];

    if (!name.trim()) errors.push('É necessário informar seu nome');

    if (!this.allCoursesCode.find((code) => code === courseCode)) {
      errors.push('Código do curso não existe');
    }

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

  saveClientSide(storage, payload) {
    const { name, courseCode, disciplines, departments, keywords } = payload;

    let info = { name, courseCode, departments, keywords };
    const { isValid, errors } = this.validateFields(info);

    if (!isValid) return errors;

    storage.clear();

    const selectedDepartments = departments.map((department) =>
      this.allDepartments.find(({ code }) => {
        const [inputCode, _] = department.split('-');
        return inputCode.trim() == code;
      })
    );

    const selectedDisciplines = disciplines.map((discipline) =>
      this.allDisciplines.find(({ code }) => {
        const [inputCode, _] = discipline.split('-');
        return inputCode.trim() == code;
      })
    );

    info = {
      name,
      courseCode,
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
