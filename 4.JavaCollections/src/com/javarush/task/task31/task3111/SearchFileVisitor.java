package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize, maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] b = Files.readAllBytes(file);
        if (b.length > minSize && b.length < maxSize && maxSize!=0) {
            if (partOfName != null) {
                if (file.getFileName().toString().contains(partOfName)) {
                    if (partOfContent != null) {
                        for (String s : Files.readAllLines(file)) {
                            if (new String(b, "UTF-8").contains(partOfContent)) {
                                foundFiles.add(file);
                                return FileVisitResult.CONTINUE;
                            }
                        }
                    } else {
                        foundFiles.add(file);
                        return FileVisitResult.CONTINUE;
                    }
                }
            } else {
                if (partOfContent != null) {
                    for (String s : Files.readAllLines(file)) {
                        if (new String(b, "UTF-8").contains(partOfContent)) {
                            foundFiles.add(file);
                            return FileVisitResult.CONTINUE;
                        }
                    }
                } else {
                    foundFiles.add(file);
                    return FileVisitResult.CONTINUE;
                }
        }
    } else if(b.length > minSize && minSize!=0 && maxSize==0) {
            if (partOfName != null) {
                if (file.getFileName().toString().contains(partOfName)) {
                    if (partOfContent != null) {
                        for (String s : Files.readAllLines(file)) {
                            if (new String(b, "UTF-8").contains(partOfContent)) {
                                foundFiles.add(file);
                                return FileVisitResult.CONTINUE;
                            }
                        }
                    } else {
                        foundFiles.add(file);
                        return FileVisitResult.CONTINUE;
                    }
                }
            } else {
                if (partOfContent != null) {
                    for (String s : Files.readAllLines(file)) {
                        if (new String(b, "UTF-8").contains(partOfContent)) {
                            foundFiles.add(file);
                            return FileVisitResult.CONTINUE;
                        }
                    }
                } else {
                    foundFiles.add(file);
                    return FileVisitResult.CONTINUE;
                }
            }

        } else if (maxSize == 0 && minSize ==0) {
            if (partOfName != null) {
                if (file.getFileName().toString().contains(partOfName)) {
                    if (partOfContent != null) {
                        for (String s : Files.readAllLines(file)) {
                            if (new String(b, "UTF-8").contains(partOfContent)) {
                                foundFiles.add(file);
                                return FileVisitResult.CONTINUE;
                            }
                        }
                    } else {
                        foundFiles.add(file);
                        return FileVisitResult.CONTINUE;
                    }
                }
            } else {
                if (partOfContent != null) {
                    for (String s : Files.readAllLines(file)) {
                        if (new String(b, "UTF-8").contains(partOfContent)) {
                            foundFiles.add(file);
                            return FileVisitResult.CONTINUE;
                        }
                    }
                } else {
                    foundFiles.add(file);
                    return FileVisitResult.CONTINUE;
                }
            }
        }
        return FileVisitResult.CONTINUE;
    }

    public void setPartOfName(String pn){
        partOfName = pn;
    }

    public void setPartOfContent(String pc){
        partOfContent = pc;
    }

    public void setMinSize(int min){
        minSize = min;
    }
    public void setMaxSize(int max){
        maxSize = max;

    }

    public List<Path> getFoundFiles(){
        return foundFiles;
    }
}
