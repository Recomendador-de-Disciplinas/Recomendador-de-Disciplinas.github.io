export function saveClientSide(storage, info) {
  Object.keys(info).forEach((field) => {
    storage.setItem(field, JSON.stringify(info[field]));
  });
}
