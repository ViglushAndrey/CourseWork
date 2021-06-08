package com.example.coursework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * course.Armament
 *
 * @Autor: Andrey
 * @DateTime: 03.03.2021|16:55
 * @Version: Armament: 1.0
 */
@Document
public class Armament {

    @Id
    private String id;
    private Grenades grenades;
    private Pistols pistols;
    private SniperRifles sniperRifles;
    private MachinesGuns machinesGuns;
    private Automats automats;
    private MilitaryEquipment militaryEquipment;
    private TransportEquipment transportEquipment;
    private LocalDateTime created_at;
    private LocalDateTime modify_at;

    public Armament() {
    }

    public Armament(String id, Grenades grenades, Pistols pistols, SniperRifles sniperRifles, MachinesGuns machinesGuns, Automats automats, MilitaryEquipment militaryEquipment, TransportEquipment transportEquipment, LocalDateTime created_at, LocalDateTime modify_at) {
        this.id = id;
        this.grenades = grenades;
        this.pistols = pistols;
        this.sniperRifles = sniperRifles;
        this.machinesGuns = machinesGuns;
        this.automats = automats;
        this.militaryEquipment = militaryEquipment;
        this.transportEquipment = transportEquipment;
        this.created_at = created_at;
        this.modify_at = modify_at;
    }

    public Armament(Grenades grenades, Pistols pistols, SniperRifles sniperRifles, MachinesGuns machinesGuns, Automats automats, MilitaryEquipment militaryEquipment, TransportEquipment transportEquipment, LocalDateTime created_at, LocalDateTime modify_at) {
        this.grenades = grenades;
        this.pistols = pistols;
        this.sniperRifles = sniperRifles;
        this.machinesGuns = machinesGuns;
        this.automats = automats;
        this.militaryEquipment = militaryEquipment;
        this.transportEquipment = transportEquipment;
        this.created_at = created_at;
        this.modify_at = modify_at;
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

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getModify_at() {
        return modify_at;
    }

    public void setModify_at(LocalDateTime modify_at) {
        this.modify_at = modify_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Armament armament = (Armament) o;
        return getId().equals(armament.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Armament{" +
                "id='" + id + '\'' +
                ", grenades=" + grenades +
                ", pistols=" + pistols +
                ", sniperRifles=" + sniperRifles +
                ", machinesGuns=" + machinesGuns +
                ", automats=" + automats +
                ", militaryEquipment=" + militaryEquipment +
                ", transportEquipment=" + transportEquipment +
                ", created_at=" + created_at +
                ", modify_at=" + modify_at +
                '}';
    }
}
    