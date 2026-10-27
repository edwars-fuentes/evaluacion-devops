# Evaluación Parcial N°2 - Ingeniería DevOps (DOY0101)

## Integrantes del Equipo
* **Nombre:** Edwars Alexis Andree Fuentes Mella
* **Asignatura:** Ingeniería DevOps (DOY0101)
* **Institución:** Duoc UC

---

## 1. Descripción del Proyecto
Este proyecto consiste en un microservicio desarrollado en Java con Spring Boot, automatizado completamente a través de un pipeline de CI/CD configurado en GitHub Actions. El ciclo de vida abarca desde la compilación y ejecución de pruebas unitarias hasta el escaneo de seguridad, la generación de imágenes en Docker y la orquestación con Docker Compose.

---

## 2. Arquitectura del Pipeline CI/CD

El pipeline de GitHub Actions (`.github/workflows/ci-cd.yml`) se activa de forma automática en cada `push` o `pull_request` a las ramas principales (`main`/`master`) y se divide en 3 etapas principales:

1. **Pruebas Unitarias (`unit-tests`):**
   * Configura JDK 17 y utiliza Apache Maven para ejecutar el conjunto de pruebas unitarias (`mvn test`) implementadas con JUnit.
2. **Análisis de Seguridad y Dependencias (`security-analysis`):**
   * Incorpora herramientas de análisis estático y escaneo de vulnerabilidades (Trivy / Snyk).
   * **Bloqueo de seguridad:** Configurado para interrumpir la ejecución del pipeline con código de salida `1` en caso de detectar vulnerabilidades de severidad `CRITICAL` o `HIGH`.
3. **Construcción y Despliegue de Imagen (`build-docker`):**
   * Genera la imagen optimizada de Docker utilizando construcciones multi-etapa (*multi-stage build*) para garantizar un entorno liviano y seguro en producción.

---

## 3. Trazabilidad y Calidad de Software

Para garantizar la trazabilidad y calidad en cada despliegue:
* **Trazabilidad:** Cada paso ejecutado en GitHub Actions queda registrado con el commit hash correspondiente, permitiendo asociar de forma transparente el código fuente con la versión de la imagen del contenedor generada.
* **Calidad y Políticas:** No se permite la generación o despliegue de imágenes de Docker si el código no aprueba el 100% de las pruebas unitarias o si existen fallos críticos de seguridad en las dependencias.

---

## 4. Guía de Ejecución Local con Orquestación

Para ejecutar y orquestar el microservicio de forma local usando Docker Compose:

```bash
# 1. Construir y levantar los contenedores
docker-compose up --build -d

# 2. Verificar el estado del contenedor
docker-compose ps

# 3. Detener la orquestación
docker-compose down