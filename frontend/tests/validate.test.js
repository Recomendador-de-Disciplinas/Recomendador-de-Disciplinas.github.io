import validateFields from '../src/services/Validate';

describe(validateFields, () => {
  const coursesCodesMock = ['45052'];

  it('should accept without errors', () => {
    const validUserData = {
      name: 'valid-user',
      courseCode: '45052',
      departments: ['MAC - Ciência da Computação'],
      disciplines: [],
      keywords: ['Computação'],
    };

    const { isValid, errors } = validateFields(validUserData, coursesCodesMock);
    expect(isValid).toBe(true);
    expect(errors.length).toBe(0);
  });

  it('should return errors when info is not valid', () => {
    const userData = {
      name: '',
      courseCode: '',
      disciplines: [],
      departments: ['MAC - Ciência da Computação'],
      keywords: [],
    };

    const { errors } = validateFields(userData, coursesCodesMock);

    expect(errors.length).toBe(3);
  });
});
