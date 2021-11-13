/* eslint-disable no-undef */
import Form from './forms';

describe(Form.saveClientSide, () => {
  const allDepartments = [{ code: 'MAC' }];
  const allDisciplines = [{ code: 'MAC0444' }];
  const allCoursesCode = ['45052'];
  let storageMock;
  let form;

  beforeAll(() => {
    storageMock = {
      setItem: jest.fn(),
      clear: jest.fn(),
    };
    form = new Form(allCoursesCode, allDepartments, allDisciplines);
  });

  it('should return errors when info is not valid', () => {
    const info = {
      name: '',
      courseCode: '',
      disciplines: [],
      departments: ['MAC - Departamento de Ciência da Computação'],
      keywords: [],
    };

    const errors = form.saveClientSide(storageMock, info);

    expect(errors.length).toBe(3);
  });

  it('should not call setItem from storage when info is not valid', () => {
    const info = {
      name: '',
      courseCode: '',
      disciplines: [],
      departments: ['MAC - Departamento de Ciência da Computação'],
      keywords: [],
    };

    form.saveClientSide(storageMock, info);

    expect(storageMock.setItem).not.toHaveBeenCalled();
    expect(storageMock.clear).not.toHaveBeenCalled();
  });

  it('should save in the storage when info is valid', () => {
    const info = {
      name: 'Erick',
      courseCode: '45052',
      disciplines: ['MAC0444'],
      departments: ['MAC - Departamento de Ciência da Computação'],
      keywords: ['Computação'],
    };

    form.saveClientSide(storageMock, info, allDepartments, allDisciplines);

    expect(storageMock.clear).toHaveBeenCalledTimes(1);
    expect(storageMock.setItem).toHaveBeenCalledTimes(5);
  });
});
