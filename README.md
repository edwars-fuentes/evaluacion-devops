# Microservicio DevOps - Evaluación Parcial N°3 (`DOY0101`)

Repositorio del microservicio `evaluacion-devops-service` (Spring Boot / Java 17) y su automatización de ciclo de vida, observabilidad, manifiestos de orquestación y control de calidad/seguridad mediante GitHub Actions y Docker.

## 1. Monitoreo, Logs y Observabilidad (IE1)
- **Spring Boot Actuator y métricas:** Expone los endpoints `health`, `info` y `prometheus` (con `show-details: always` en salud y etiqueta `application: evaluacion-devops-service`).
- **Stack de observabilidad:** Integración mediante `docker-compose.yml` con Prometheus (`prometheus.yml`), Loki, Promtail (`promtail-config.yml`) y Grafana para supervisar disponibilidad, métricas del servicio/JVM y registros de contenedores.

## 2. Manifiestos de Orquestación (IE2)
- **Definición declarativa en repositorio (`K8s/`):** Manifiestos base de Kubernetes (`namespace.yaml`, `deployment.yaml` y `service.yaml`) preparados en el repositorio con configuración de entorno (`SPRING_PROFILES_ACTIVE=prod`), probes de salud y anotaciones de scraping para Prometheus, sin requerir un clúster cloud activo en el entorno local.

## 3. Dashboards y Métricas Integradas al CI/CD (IE3)
- **Visualización en Grafana:** Paneles de observabilidad conectados a Prometheus y Loki para revisar uso de memoria JVM, CPU del proceso, errores HTTP (como `500` en `/error-test`) y trazabilidad vinculada al flujo de CI/CD (duración/tiempo de despliegue y cobertura de pruebas).

## 4. Decisiones Técnicas y Mejora Continua (IE4)
- **Decisiones técnicas:**
  - Mantener la stack local de monitoreo y logs en Docker Compose para validar observabilidad de forma reproducible sin costos de infraestructura en la nube.
  - Documentar manifiestos declarativos en `K8s/` como base de orquestación manteniendo el flujo de trabajo ágil y directo.
  - Estandarizar métricas y etiquetas desde `application.yaml` para mantener coherencia entre el microservicio, Prometheus y Grafana.
- **Mejora continua:**
  - Refinar paneles y consultas en Grafana a partir de pruebas reales de carga y errores.
  - Ampliar la automatización de reportes de cobertura y métricas del pipeline hacia la visualización en dashboards.
  - Evaluar despliegues en entornos orquestados adicionales si el proyecto escala a etapas posteriores.

## 5. Políticas de Cumplimiento y Corte de Pipeline (IE5 y IE6)
- **Políticas y controles en CI/CD:** Validación automatizada con Maven (`unit-tests`), análisis de seguridad con escaneo de vulnerabilidades configurado con corte ante hallazgos críticos/altos (`exit-code: '1'`) y construcción de imagen Docker (`microservicio-devops:latest`).
- **Corte controlado ante fallas:** Verificación del bloqueo automático del pipeline en Pull Request cuando falla una validación, evitando integrar cambios rotos en `main`.

## Declaración de Uso de Inteligencia Artificial (IA)
De acuerdo con las normativas éticas del curso, se declara que se utilizó asistencia de Inteligencia Artificial como apoyo técnico para la revisión y estructuración de configuraciones (YAML/Docker/observabilidad/manifiestos), diagnóstico de problemas y redacción de apoyo de este documento. El análisis técnico, las pruebas, la validación de resultados y las decisiones finales fueron revisados por mí como autor del proyecto.

## Reflexión Individual
Por mi parte, lo que más me costó fue la configuración de Prometheus y Grafana, ya que al principio no tenía claro cómo usar cada cosa, pero con el tiempo me fui acostumbrando a cada parte. Lo que aprendí fue utilizar con más facilidad Grafana y organizar nuevas carpetas como `K8s`. Lo que añadiría sería sumar funciones para Docker Desktop, a lo que me refiero es que se pueda crear algo directamente desde Docker Desktop.
