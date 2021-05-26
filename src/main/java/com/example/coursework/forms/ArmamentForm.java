package com.example.coursework.forms;

import com.example.coursework.model.*;

public class ArmamentForm {
    private String id;
    private Grenades grenades;
    private Pistols pistols;
    private SniperRifles sniperRifles;
    private MachinesGuns machinesGuns;
    private Automats automats;
    private MilitaryEquipment militaryEquipment;
    private TransportEquipment transportEquipment;

    public ArmamentForm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Grenades getGrenades() {
        return grenades;
    }

    public void setGrenades(Grenades grenades) {
        this.grenades = grenades;
    }

    public Pistols getPistols() {
        return pistols;
    }

    public void setPistols(Pistols pistols) {
        this.pistols = pistols;
    }

    public SniperRifles getSniperRifles() {
        return sniperRifles;
    }

    public void setSniperRifles(SniperRifles sniperRifles) {
        this.sniperRifles = sniperRifles;
    }

    public MachinesGuns getMachinesGuns() {
        return machinesGuns;
    }

    public void setMachinesGuns(MachinesGuns machinesGuns) {
        this.machinesGuns = machinesGuns;
    }

    public Automats getAutomats() {
        return automats;
    }

    public void setAutomats(Automats automats) {
        this.automats = automats;
    }

    public MilitaryEquipment getMilitaryEquipment() {
        return militaryEquipment;
    }

    public void setMilitaryEquipment(MilitaryEquipment militaryEquipment) {
        this.militaryEquipment = militaryEquipment;
    }

    public TransportEquipment getTransportEquipment() {
        return transportEquipment;
    }

    public void setTransportEquipment(TransportEquipment transportEquipment) {
        this.transportEquipment = transportEquipment;
    }

    @Override
    public String toString() {
        return "ArmamentForm{" +
                "id='" + id + '\'' +
                ", grenades=" + grenades +
                ", pistols=" + pistols +
                ", sniperRifles=" + sniperRifles +
                ", machinesGuns=" + machinesGuns +
                ", automats=" + automats +
                ", militaryEquipment=" + militaryEquipment +
                ", transportEquipment=" + transportEquipment +
                '}';
    }
}
