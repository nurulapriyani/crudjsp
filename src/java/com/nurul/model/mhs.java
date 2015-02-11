/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nurul.model;

/**
 *
 * @author windows 8
 */
public class mhs{
    private String id;
    private String nama;
    private String npm;
    private String tgl_lahir;
    private String jk;
    private String alamat;
    
     public void setId(String id)
    {
        this.id=id;
    }
    public void setNama(String nama)
    {
        this.nama=nama;
    }
    public void setNpm(String npm)
    {
        this.npm=npm;
    }
    public void setTgl_lahir(String tgl_lahir)
    {
        this.tgl_lahir=tgl_lahir;
    }
    public void setJk(String jk)
    {
        this.jk=jk;
    }
    public void setAlamat(String alamat)
    {
        this.alamat=alamat;
    }
     public String getId()
    {
        return this.id;
    }
    public String getNama()
    {
        return this.nama;
    }
    public String getNpm()
    {
        return this.npm;
    }
    public String getTgl_lahir()
    {
        return this.tgl_lahir;
    }
    public String getJk()
    {
        return this.jk;
    }
    public String getAlamat()
    {
        return this.alamat;
    }
}
