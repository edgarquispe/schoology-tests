package org.example.schoology.pages.resources;

import java.util.Map;

public class CreateFolderResourcePopup extends AbstractAddFolderResourcePopup {

    public Resource create(final Map<AddFolderForm, String> folderResourceMap) {
        fill(folderResourceMap);
        submitButton().click();
        return new Resource();
    }

}
