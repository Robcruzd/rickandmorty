package com.test.rest.controllers;

import com.test.application.dto.request.CharacterRequestDto;
import com.test.application.dto.request.CharacterUpdateRequestDto;
import com.test.application.dto.response.CharacterResponseDto;
import com.test.rest.exception.ApplicationException;
import com.test.application.usecase.ICharacterUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rickandmorty/character")
@RequiredArgsConstructor
public class CharacterRestController {

    private final ICharacterUseCase characterUseCase;

    @Operation(summary = "Add Character")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Character added", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error adding the character", content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<String> save(@RequestBody CharacterRequestDto characterRequestDto) {
        try {
            characterUseCase.save(characterRequestDto);
            return ResponseEntity.ok("");
        } catch (ApplicationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Operation(summary = "Update Character")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Character updated", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error updating character", content = @Content)
    })
    @PutMapping("/")
    public ResponseEntity<String> updateCharacter(@RequestBody CharacterUpdateRequestDto characterUpdateRequestDto) {
        try {
            characterUseCase.update(characterUpdateRequestDto);
            return ResponseEntity.ok("");
        } catch (ApplicationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Operation(summary = "Find Character by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Character finded", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error finding character", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<CharacterResponseDto> findById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(characterUseCase.findById(id), HttpStatus.OK);
        } catch (ApplicationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Operation(summary = "Find all characters")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All characters finded", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error finding characters", content = @Content)
    })
    @GetMapping("/all")
    public ResponseEntity<List<CharacterResponseDto>> findAll() {
        try {
            return new ResponseEntity<>(characterUseCase.findAll(), HttpStatus.OK);
        } catch (ApplicationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Operation(summary = "Delete Character by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Character finded", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error finding character", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        try {
            characterUseCase.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (ApplicationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
