import {
  getDataFromStorage,
  getComputedDataFromStorage,
  saveDataInStorage,
} from '../src/services/Storage';

describe(saveDataInStorage, () => {
  const dcc = {
    code: 'MAC',
    id: 1,
    name: 'Ciência da Computação',
    url: 'Foo',
  };
  const backendData = {
    allDepartments: [dcc],
    allDisciplines: [
      {
        code: 'MAC0444',
        department: dcc,
        id: 2,
        name: 'Sistemas Baseados em Conhecimentos',
        url: 'Bar',
      },
    ],
    allCoursesCode: ['45052'],
  };
  let storageMock;

  beforeAll(() => {
    storageMock = {
      setItem: jest.fn(),
      clear: jest.fn(),
    };
  });

  it('should save in the storage when info is valid', () => {
    const userData = {
      name: 'Erick',
      courseCode: '45052',
      disciplines: ['MAC0444 - Sistemas Baseados em Conhecimentos'],
      departments: ['MAC - Ciência da Computação'],
      keywords: ['sistemas'],
    };
    const payload = {
      userData,
      backendData,
    };

    saveDataInStorage(storageMock, payload);

    expect(storageMock.clear).toHaveBeenCalledTimes(1);
    expect(storageMock.setItem).toHaveBeenCalledTimes(5);
  });
});

describe(getDataFromStorage, () => {
  const dcc = {
    code: 'MAC',
    id: 1,
    name: 'Ciência da Computação',
    url: 'Foo',
  };
  const storageData = {
    name: 'User',
    disciplines: [
      {
        code: 'MAC0110',
        department: dcc,
        id: 2,
        name: 'Introdução à Computação',
        url: 'Bar',
      },
    ],
    departments: [dcc],
    keywords: ['Computação'],
    courseCode: '45052',
  };
  let storageMock;

  beforeAll(() => {
    storageMock = {
      getItem: jest.fn((key) => JSON.stringify(storageData[key])),
    };
  });

  it('should return all saved data', () => {
    const data = getDataFromStorage(storageMock);
    expect(data).toEqual(expect.objectContaining(storageData));
  });

  it('should work even though data does not exist', () => {
    const expectData = {
      name: '',
      disciplines: [],
      departments: [],
      keywords: [],
      courseCode: '',
    };
    storageMock.getItem.mockReturnValue(null);
    const data = getDataFromStorage(storageMock);
    expect(data).toEqual(expect.objectContaining(expectData));
  });
});

describe(getComputedDataFromStorage, () => {
  const dcc = {
    code: 'MAC',
    id: 1,
    name: 'Ciência da Computação',
    url: 'Foo',
  };
  const storageData = {
    name: 'User',
    disciplines: [
      {
        code: 'MAC0110',
        department: dcc,
        id: 2,
        name: 'Introdução à Computação',
        url: 'Bar',
      },
    ],
    departments: [dcc],
    keywords: ['Computação'],
    courseCode: '45052',
  };
  let storageMock;

  beforeAll(() => {
    storageMock = {
      getItem: jest.fn((key) => JSON.stringify(storageData[key])),
    };
  });

  it('should return all saved data computed', () => {
    const expectData = {
      name: 'User',
      disciplines: ['MAC0110 - Introdução à Computação'],
      departments: ['MAC - Ciência da Computação'],
      keywords: ['Computação'],
      courseCode: '45052',
    };
    const data = getComputedDataFromStorage(storageMock);
    expect(data).toEqual(expect.objectContaining(expectData));
  });

  it('should work even though data does not exist', () => {
    const expectData = {
      name: '',
      disciplines: [],
      departments: [],
      keywords: [],
      courseCode: '',
    };
    storageMock.getItem.mockReturnValue(null);
    const data = getComputedDataFromStorage(storageMock);
    expect(data).toEqual(expect.objectContaining(expectData));
  });
});
