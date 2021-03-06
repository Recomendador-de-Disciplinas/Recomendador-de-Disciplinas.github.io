export default function validateFields(userData, allCoursesCode) {
  const { name, courseCode, departments, keywords } = userData;
  const errors = [];

  if (!name.trim()) errors.push('É necessário informar seu nome');

  if (!allCoursesCode.find((code) => code === courseCode)) {
    errors.push('Código do curso não existe');
  }

  if (departments.length === 0)
    errors.push('É necessário informar ao menos um departamento de interesse');

  if (keywords.length === 0)
    errors.push('É necessário informar ao menos um tópico de interesse');

  return {
    isValid: errors.length === 0,
    errors,
  };
}
