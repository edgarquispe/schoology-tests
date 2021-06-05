package org.example.schoology.pages.resources;

public enum AddFolderForm {
    FOLDER_NAME("Name"),
    FOLDER_COLOR("Folder Color");

    private final String name;

    AddFolderForm(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
