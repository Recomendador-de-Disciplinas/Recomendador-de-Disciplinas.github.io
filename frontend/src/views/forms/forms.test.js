import { saveClientSide } from './forms' 

describe(saveClientSide, () => {
  it("should save in the storage", () => {
    const info = { 
      name: "Erick",
      disciplines: ["MAC444"],
      departments: ["MAC"]
    }
    const storageMock = { setItem: jest.fn() }
    saveClientSide(storageMock, info)
    
    expect(storageMock.setItem).toHaveBeenCalledTimes(3)
  })
})