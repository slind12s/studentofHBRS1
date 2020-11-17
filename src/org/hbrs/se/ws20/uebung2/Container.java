package org.hbrs.se.ws20.uebung2;

import java.util.ArrayList;

public class Container implements Member {
    ArrayList <Member> list = new ArrayList<>();
    Member member;
    int schluessel;



    public void addMember(Member member1) throws ContainerException {
        this.member = member1;
        for (int aktuellePos = 0; aktuellePos < size(); ++aktuellePos){
            Member aktuell = list.get(aktuellePos);
            if( member.getID().equals(aktuell.getID())){
                throw new ContainerException();
            }

        }
        list.add(member);


    }
    public String deleteMember (Integer id){
        boolean vorhanden = false;
        for( int aktuellePos = 0; aktuellePos < size(); ++aktuellePos){
            Member aktuell = list.get(aktuellePos);
            if(id.equals(aktuell.getID())){
                vorhanden = true;
                list.remove(aktuellePos);
            }
        }

        if(vorhanden == false){
            return "Die zugehörige ID befindet sich nicht in der Liste";
        }

        return "Die ID wurde erfolgreich aus der Liste entfernt";
    }
    //Wenn man keine Exception nutzt kann es zu Problemen beim Verständnis kommen.
    public void dump(){
        Container clone = new Container();
        clone.list = this.list;
        while(clone.size()!= 0){
            System.out.println(clone.toString());
            list.remove(clone.size());
        }
    }
    @Override
    public String toString() {

        return "Member (ID =[" + member.getID()+ "])";
    }
    public int size(){
        return list.size();
    }

    @Override
    public Integer getID() {
        return schluessel;
    }


}

