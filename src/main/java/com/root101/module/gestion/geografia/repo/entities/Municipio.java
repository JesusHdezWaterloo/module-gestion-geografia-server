/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.root101.module.gestion.geografia.repo.entities;

import com.root101.module.gestion.geografia.repo.utils.ResourcesGeografia;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 */
@Entity
@Table(name = "municipio", schema = ResourcesGeografia.SCHEMA, uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nombre_municipio"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m"),
    @NamedQuery(name = "Municipio.findByIdMunicipio", query = "SELECT m FROM Municipio m WHERE m.idMunicipio = :idMunicipio"),
    @NamedQuery(name = "Municipio.findByNombreMunicipio", query = "SELECT m FROM Municipio m WHERE m.nombreMunicipio = :nombreMunicipio"),
    @NamedQuery(name = "Municipio.findByDescripcion", query = "SELECT m FROM Municipio m WHERE m.descripcion = :descripcion")})
public class Municipio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_municipio", nullable = false)
    private Integer idMunicipio;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_municipio", nullable = false, length = 100)
    private String nombreMunicipio;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;
    
    @JoinColumn(name = "provincia_fk", referencedColumnName = "id_provincia", nullable = false)
    @ManyToOne(optional = false)
    private Provincia provinciaFk;

    public Municipio() {
    }

    public Municipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public Municipio(Integer idMunicipio, String nombreMunicipio, String descripcion) {
        this.idMunicipio = idMunicipio;
        this.nombreMunicipio = nombreMunicipio;
        this.descripcion = descripcion;
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Provincia getProvinciaFk() {
        return provinciaFk;
    }

    public void setProvinciaFk(Provincia provinciaFk) {
        this.provinciaFk = provinciaFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMunicipio != null ? idMunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.idMunicipio == null && other.idMunicipio != null) || (this.idMunicipio != null && !this.idMunicipio.equals(other.idMunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.root101.module.gestion.geografia.repo.entities.Municipio[ idMunicipio=" + idMunicipio + " ]";
    }

}
