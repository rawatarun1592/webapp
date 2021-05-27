package com.kakinos.webapp;

import com.bezkoder.spring.data.mongodb.model.Tutorial;
import com.bezkoder.spring.data.mongodb.repository.TutorialRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TutorialController {

  @Autowired
  TutorialRepository tutorialRepository;

  @GetMapping("/DataModel")
  public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
    
  }
  @GetMapping("/DataModel/{id}")
  public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") String id) {
    
  }

  @PostMapping("/DataModel")
  public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
    
  }

  @PutMapping("/DataModel/{id}")
  public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") String id, @RequestBody Tutorial tutorial) {
    
  }

  @DeleteMapping("/DataModel/{id}")
  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") String id) {
    
  }

  @DeleteMapping("/DataModel")
  public ResponseEntity<HttpStatus> deleteAllTutorials() {
    
  }
  @GetMapping("/DataModel/published")
  public ResponseEntity<List<DataModel>> findByPublished() {
    
  }

}