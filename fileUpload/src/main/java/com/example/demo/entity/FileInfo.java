package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="file_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileInfo {

    @Id
    private Integer id;
    private String name;
    private String url;


    public FileInfo(String filename, String url) {
        this.name = filename;
        this.url = url;
    }
}
