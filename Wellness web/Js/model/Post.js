class Post{

    constructor(title,description,date){
        this.title=title;
        this.description=description
        this.date=date;
        Object.seal(this);
    }
    
}