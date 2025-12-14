package com.keerthi.ChallengeApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class ChallengeController {
    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService){
        this.challengeService=challengeService;
    }

    @GetMapping("/challenges")
    public ResponseEntity<List<Challenge>> getAllChallenges(){
        return new ResponseEntity<>(challengeService.getAllChallenge(),HttpStatus.OK);
    }

    @PostMapping("/challenges")
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge){
    boolean isChallengeAdded = challengeService.addChallenge(challenge);
    if(isChallengeAdded)
        return new ResponseEntity<>("Challenge added successfully",HttpStatus.OK);
    else
        return new ResponseEntity<>("challenge not added successfully",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/challenges/{month}")
    public ResponseEntity<Challenge> getAChallenges(@PathVariable String month){
        Challenge challenge = challengeService.getChallenge(month);
        if(challenge !=null)
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    @PutMapping("/challenges/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id,@RequestBody Challenge updatedChallenge){
        boolean isChallengeUpdated = challengeService.updatChallenge(id,updatedChallenge);
        if(isChallengeUpdated)
            return new ResponseEntity<>("Challenge added successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("challenge not added successfully",HttpStatus.NOT_FOUND);
    }
}
