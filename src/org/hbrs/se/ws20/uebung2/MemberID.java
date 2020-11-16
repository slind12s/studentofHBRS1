package org.hbrs.se.ws20.uebung2;

public class MemberID extends Container implements Member {
    int ID = 0;
    Member member = new Member() {
        @Override
        public Integer getID() {
            return null;
        }
    };
    public MemberID(){
        this.ID = ID +1;
    }
    public int IDWert(){
        return ID;
    }

}
