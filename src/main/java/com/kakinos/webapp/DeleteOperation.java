package com.kakinos.webapp;

@DeleteMapping("/tutorials/{id}")
public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") String id) {
  try {
    tutorialRepository.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  } catch (Exception e) {
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }
}

@DeleteMapping("/tutorials")
public ResponseEntity<HttpStatus> deleteAllTutorials() {
  try {
    tutorialRepository.deleteAll();
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  } catch (Exception e) {
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
