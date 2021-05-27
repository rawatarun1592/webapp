package com.kakinos.webapp;

@PostMapping("/tutorials")
public ResponseEntity<Tutorial> createT(@RequestBody Tutorial tutorial) {
  try {
    Tutorial _tutorial = tutorialRepository.save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
    return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
  } catch (Exception e) {
    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
  }
