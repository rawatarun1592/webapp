package com.kakinos.webapp;

PutMapping("/tutorials/{id}")
public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") String id, @RequestBody Tutorial tutorial) {
  Optional<Tutorial> tutorialData = tutorialRepository.findById(id);

  if (tutorialData.isPresent()) {
    Tutorial _tutorial = tutorialData.get();
    _tutorial.setTitle(tutorial.getTitle());
    _tutorial.setDescription(tutorial.getDescription());
    _tutorial.setPublished(tutorial.isPublished());
    return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
  } else {
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
