static ListaDeEnterosEnlazada mergeSort (ListaDeEnterosEnlazada l) {
  ListaDeEnterosEnlazada result = new ListaDeEnterosEnlazada();
  
  for (int i = 0; i < l.tamanio(); i++) result.agregarFinal(l.elemento(i));
  
  result = recursive(result);
  return result;
}

static ListaDeEnterosEnlazada recursive (ListaDeEnterosEnlazada result) {
  result.tamanio();
  if (result.tamanio() > 1) {
    ListaDeEnterosEnlazada second = new ListaDeEnterosEnlazada();
    int limit = (result.tamanio() / 2) + (result.tamanio() % 2);

    for (int i = limit; i < result.tamanio(); i++) { // create second list
      second.agregarFinal(result.elemento(i));
    }
    for (int i = limit; i <= result.tamanio(); i++) { // clean result list
      result.eliminarEn(limit);
    }

    result = recursive(result);
    second = recursive(second);
    
    return result.combinarOrdenado(second);
  }
  
  return result;
}