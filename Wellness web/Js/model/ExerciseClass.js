class ExerciseClass extends Post{

    constructor(images,texts,link){
        this.images=[];
        this.images=images;
        this.texts=[]
        this.texts=texts;
        this.link=link
        Object.seal(this);
    }

}