# bsx-firma
libreria y app de escritorio para firmar documentos electronicamente para ecuador

## requerimientos
- jdk 8 o superior. 
- gradle

## Compilar y distribuible
<code> gradle clean build distZip</code>

copiar distribuible de build/distributions/bsx-firma.zip

## Uso
<code> 
bsx-firma.bat c:\\firma.p12 miclave c:\\documento.pdf c:\\documento_firmada.pdf </code>


- param1 ruta firma archivo .p12

- param2 clave firma

- param3 ruta archivo pdf

- param4 ruta archivo pdf firmado

