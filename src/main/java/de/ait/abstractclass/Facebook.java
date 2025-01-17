package de.ait.abstractclass;

public class Facebook extends SocialMedia{
public Facebook(String userName){
    super(userName);
}

    @Override
    public void postContent(String content) {
        System.out.println(getUserName()+ "posted: "+content + "on Facebook");
    }
}
