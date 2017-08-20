export class LoggedUser {
    public userId : number
    public userName : string
    public userType : string
    public joinDate : Date
    public name : string
    public password : string

    constructor(
         userName : string, 
         password : string, 
         userId ?: number, 
         userType ?: string,
         joinDate ?: Date,
         name ?: string,
  ) {
      this.userId = userId;
      this.userName = userName;
      this.password = password;
      this.joinDate = joinDate;
      this.userType = userType;
      this.name = name;
   }
}
