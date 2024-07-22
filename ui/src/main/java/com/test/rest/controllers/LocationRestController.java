package com.test.rest.controllers;

import com.test.application.dto.request.LocationRequestDto;
import com.test.application.dto.request.LocationUpdateRequestDto;
import com.test.application.dto.response.LocationResponseDto;
import com.test.rest.exception.ApplicationException;
import com.test.application.usecase.ILocationUseCase;
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
@RequestMapping("/api/v1/rickandmorty/location")
@RequiredArgsConstructor
public class LocationRestController {

    private final ILocationUseCase locationUseCase;

    @Operation(summary = "Add Location")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Location added", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error adding the location", content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<String> save(@RequestBody LocationRequestDto locationRequestDto) {
        try {
            locationUseCase.save(locationRequestDto);
            return ResponseEntity.ok("");
        } catch (ApplicationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Operation(summary = "Update Location")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Location updated", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error updating location", content = @Content)
    })
    @PutMapping("/")
    public ResponseEntity<String> updateLocation(@RequestBody LocationUpdateRequestDto locationUpdateRequestDto) {
        try {
            locationUseCase.update(locationUpdateRequestDto);
            return ResponseEntity.ok("");
        } catch (ApplicationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Operation(summary = "Find Location by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Location finded", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error finding location", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<LocationResponseDto> findById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(locationUseCase.findById(id), HttpStatus.OK);
        } catch (ApplicationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Operation(summary = "Find all locations")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All locations finded", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error finding locations", content = @Content)
    })
    @GetMapping("/all")
    public ResponseEntity<List<LocationResponseDto>> findAll() {
        try {
            return new ResponseEntity<>(locationUseCase.findAll(), HttpStatus.OK);
        } catch (ApplicationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Operation(summary = "Delete Location by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Location finded", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error finding location", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        try {
            locationUseCase.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (ApplicationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
