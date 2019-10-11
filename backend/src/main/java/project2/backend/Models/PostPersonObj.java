package project2.backend.Models;

public class PostPersonObj {
    public String username;
    public Long id;
    public String content;
    public String title;
    public PostPersonObj(String username, Long id, String content, String title){
        this.username = username;
        this.id = id;
        this.content = content;
        this.title = title;
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getContent(){
        return this.content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }
}
