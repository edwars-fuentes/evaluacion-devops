#  Microservicio DevOps - Evaluación Parcial N°2

Repositorio oficial para la automatización del ciclo de vida del software mediante un pipeline de CI/CD implementado en **GitHub Actions**, cumpliendo con los estándares de contenedorización, pruebas automatizadas, análisis de seguridad, orquestación y trazabilidad.

---

##  1. Arquitectura y Contenerización (IE1)
El microservicio está desarrollado en **Spring Boot** (Java 17) y empaquetado mediante un contenedor optimizado utilizando un **`Dockerfile`** multi-etapa que garantiza imágenes ligeras y seguras para entornos cloud.

* **Estrategia de contenedores:** Se aislaron las dependencias del runtime utilizando una imagen base de Eclipse Temurin (OpenJDK), optimizando el rendimiento y reduciendo la superficie de vulnerabilidades.

---

##  2. Integración Continua y Pruebas Automatizadas (IE2)
El pipeline en GitHub Actions ejecuta de manera automatizada las pruebas unitarias e integración de código en cada `push` o `pull_request` hacia la rama principal:
* **Framework:** JUnit / Maven Test.
* **Política de calidad:** El flujo se detiene inmediatamente si las pruebas unitarias fallan, asegurando la estabilidad antes de avanzar a las etapas de seguridad y despliegue.

---

##  3. Seguridad y Análisis de Dependencias (IE3)
Para cumplir con la gobernanza y los estándares de seguridad, el pipeline integra:
* **Escaneo de Vulnerabilidades (Trivy / Snyk):** Analiza el sistema de archivos del proyecto en busca de vulnerabilidades críticas y altas.
* **Bloqueo Automático:** Configurado con `exit-code: '1'`, el pipeline bloquea y rechaza cualquier integración si se detectan fallas graves de seguridad, garantizando que código vulnerable no llegue a producción.

---

##  4. Trazabilidad y Despliegue Automatizado (IE4)
El pipeline asegura la **trazabilidad completa** desde el desarrollo local hasta el entorno cloud simulado:
1. **Desarrollo y Control de Versiones:** Registro de commits y trazabilidad en GitHub (`main`).
2. **Validación Automática:** Ejecución secuencial de jobs (`unit-tests` ➔ `security-analysis` ➔ `build-docker`).
3. **Construcción de Imagen:** Generación automática de la imagen Docker etiquetada como `microservicio-devops:latest`.

---

##  5. Orquestación de Contenedores (IE5)
Para gestionar soluciones escalables de mediana y gran envergadura, el proyecto incluye un archivo **`docker-compose.yml`** que permite levantar y orquestar el microservicio de manera local o en servidores cloud simulados garantizando su correcta conectividad y persistencia.

---

## Declaración de Uso de Inteligencia Artificial (IA)
De acuerdo con las normativas éticas del curso, se declara que se utilizó asistencia de Inteligencia Artificial como herramienta de apoyo técnico para la depuración de errores de compilación de Maven, la estructuración de la sintaxis del archivo YAML del pipeline en GitHub Actions y la redacción de este informe. El análisis técnico, la validación de los resultados y la implementación final fueron rigurosamente revisados y validados por el equipo de desarrollo.