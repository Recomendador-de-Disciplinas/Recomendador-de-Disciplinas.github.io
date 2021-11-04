/* eslint-disable no-undef */
import Form from './forms';

describe(Form.saveClientSide, () => {
  const allDepartments = [{ code: 'MAC' }];
  const allDisciplines = [{ code: 'MAC0444' }];
  let storageMock;

  beforeAll(() => {
    storageMock = {
      setItem: jest.fn(),
      clear: jest.fn(),
    };
  });

  it('should return errors when info is not valid', () => {
    const info = {
      name: '',
      disciplines: [],
      departments: ['MAC - Departamento de Ciência da Computação'],
      keywords: [],
    };
    const errors = Form.saveClientSide(
      storageMock,
      info,
      allDepartments,
      allDisciplines
    );

    expect(errors.length).toBe(2);
  });

  it('should not call setItem from storage when info is not valid', () => {
    const info = {
      name: '',
      disciplines: [],
      departments: ['MAC - Departamento de Ciência da Computação'],
      keywords: [],
    };
    Form.saveClientSide(storageMock, info, allDepartments, allDisciplines);

    expect(storageMock.setItem).not.toHaveBeenCalled();
    expect(storageMock.clear).not.toHaveBeenCalled();
  });

  it('should save in the storage when info is valid', () => {
    const info = {
      name: 'Erick',
      disciplines: ['MAC0444'],
      departments: ['MAC - Departamento de Ciência da Computação'],
      keywords: ['Computação'],
    };
    Form.saveClientSide(storageMock, info, allDepartments, allDisciplines);

    expect(storageMock.clear).toHaveBeenCalledTimes(1);
    expect(storageMock.setItem).toHaveBeenCalledTimes(4);
  });
});
