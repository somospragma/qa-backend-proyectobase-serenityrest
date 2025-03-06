package co.com.pragma.model;

import lombok.Data;

@Data
public class UsuariosGetModel {
    private String page;
    private String pageResponse;
    private String per_page;
    private String total;
    private String total_pages;
    private String data;
    private String support;
    private String url;
    private String text;
    private String statusResponse;
}