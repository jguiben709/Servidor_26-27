# Instrucciones para instalar Podman Desktop en Ubuntu

## Flatpack

- sudo apt install flatpak
- Cerrar sesión o reiniciar
- flatpak remote-add --user --if-not-exists flathub https://dl.flathub.org/repo/flathub.flatpakrepo
- flatpak update --user
- Reiniciar
- flatpak install --user flathub org.freedesktop.Platform//25.08


## Podman Desktop

- Descargar desde [Podman Desktop](https://podman-desktop.io/)
- flatpak install --user ./podman-desktop-1.29.3.flatpak
