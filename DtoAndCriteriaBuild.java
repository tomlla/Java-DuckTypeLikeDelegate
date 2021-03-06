import java.util.*;

class DtoAndCriteriaBuild {
    public static void main (String [] args)
    {
        FolderSearchReq folderReq = new FolderSearchReq();
        List<String> folders = folderReq.toCriteria(new FolderCriteria()).exec();
        System.out.println(folders);

        // AttachmentSearchReq atReq = new AttachmentSearchReq();
        // List<String> attachments = atReq.toCriteria(AttachmentCriteria.class).exec();
    }
}

abstract class AbstractSearchReq {
    public String name;
    public String fullPath;
    public String userName;
    public String groupName;

    FsBaseCriteria toCriteria(FsBaseCriteria criteria) {
        return criteria
            .filterByName(name)
            .filterByFullPath(fullPath)
            .filterByUser(userName)
            .filterByGroup(groupName);
    }
}

class FolderSearchReq extends AbstractSearchReq {
}

//class AttachmentSearchReq extends AbstractSearchReq {
//}

// BaseModuleのCriteria
class AbstractCritreria {
    List<String> registerdFilters = new ArrayList<String>();

    List<String> exec() {
        return registerdFilters;
    }
}

abstract class FsBaseCriteria extends AbstractCritreria {
    abstract FsBaseCriteria filterByName(String name);
    abstract FsBaseCriteria filterByFullPath(String path);
    abstract FsBaseCriteria filterByUser(String user);
    abstract FsBaseCriteria filterByGroup(String group);
}


class FolderCriteria extends FsBaseCriteria {

    public FolderCriteria filterByName(String name) {
        registerdFilters.add("name");
        return this;
    }

    public FolderCriteria filterByFullPath(String path) {
        registerdFilters.add("path");
        return this;
    }

    public FolderCriteria filterByUser(String user) {
        registerdFilters.add("user");
        return this;
    }

    public FolderCriteria filterByGroup(String group) {
        registerdFilters.add("group");
        return this;
    }
}

//class AttachmentCriteria extends FsBaseCriteria {
//}
