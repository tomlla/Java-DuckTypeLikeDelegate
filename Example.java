import java.util.*;

class Example {
    public static void main (String [] args)
    {
        FolderSearchReq fsReq = new FolderSearchReq();
        List<String> folders = fsReq.toCriteria(FolderCriteria.class).exec();

        AttachmentSearchReq atReq = new AttachmentSearchReq();
        List<String> attachments = atReq.toCriteria(AttachmentCriteria.class).exec();
    }
}

class AbstractSearchReq {
    public String name;
    public String fullPath;
    public String userName;
    public String groupName;

    //public Criteria toCriteria() {
    //public AbstractCritreria toCriteria(AbstractCritreria criteria, Class<? extends AbstractCritreria> clazz) {
    public AbstractCritreria toCriteria(Class<? extends AbstractCritreria> clazz) {
        System.out.println("in AbstractSearchReq");
        try {
            System.out.println(clazz.newInstance().getClass().toString());
            return clazz.newInstance();
        } catch (InstantiationException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }
}

class FolderSearchReq extends AbstractSearchReq {
}

class AttachmentSearchReq extends AbstractSearchReq {
}

interface CriteriaImp {
}

class Criteria {

    static class Restriction {
    }
}

class AbstractCritreria extends Criteria {
    List<String> exec() {
        return new ArrayList<String>();
    }
}

//class FolderCriteria extends AbstractCritreria implements CriteriaImp {
class FolderCriteria extends AbstractCritreria {

    FolderCriteria filterByName() {
        return this;
    }

    FolderCriteria filterByFullPath() {
        return this;
    }

    FolderCriteria filterByUser() {
        return this;
    }

    FolderCriteria filterByGroup() {
        return this;
    }
}

//class AttachmentCriteria extends AbstractCritreria implements CriteriaImp {
class AttachmentCriteria extends AbstractCritreria {
    AttachmentCriteria filterByName() {
        return this;
    }

    AttachmentCriteria filterByFullPath() {
        return this;
    }

    AttachmentCriteria filterByUser() {
        return this;
    }

    AttachmentCriteria filterByGroup() {
        return this;
    }
}
