package org.hbrs.se.ws20.uebung2;

import java.util.ArrayList;

public class Container implements Member {
    ArrayList <Integer> list = new ArrayList<>();
    int size = 0;
    Member member;

    public void addMember(Member member1) throws ContainerException {
        member = member1;
        for( int aktuellePos = 0; aktuellePos <= size; ++aktuellePos){
            if(member.getID().equals(list.get(aktuellePos))){
                throw new ContainerException("Das Member-Objekt mit der ID " + member.getID() + "ist bereits vorhanden!");
            }
        }
        list.add(member.getID());
        ++size;
    }
    public String deleteMember (Integer id){
        for( int aktuellePos = 0; aktuellePos <= size; ++aktuellePos){
            if(id.equals(list.get(aktuellePos))){
                list.remove(aktuellePos);
            }
            if(aktuellePos == size){
                return "Die zugehörige ID befindet sich nicht in der Liste";
            }
        }
        return "Die ID wurde erfolgreich aus der Liste entfernt";
    }
    public void dump(){
        String Id = toString(member.getID());


    }

    private String toString(Integer id) {
        String AusgabeID = "Member ( ID = " + member.getID() + ")";
        return AusgabeID;
    }
    public int size(){
        return size;
    }

    @Override
    public Integer getID() {
        return null;
    }


}

