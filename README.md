# 📱 Laboratorio - Programación en Móviles (Kotlin)

Este repositorio contiene el desarrollo del **Laboratorio 02: LinearLayout, Recursos y Controles** del curso **Programación en Móviles**.

## 🎯 Objetivos
- Comprender el uso y configuración de componentes UI en Android.
- Crear y utilizar recursos (`string`, `color`, `drawable`).
- Implementar `LinearLayout` para organizar componentes.
- Manejar eventos y funciones de escucha en una `Activity`.
- Desarrollar casos prácticos con Kotlin y Android Studio.

---

## 🛠 Tecnologías Utilizadas
- **Lenguaje:** Kotlin  
- **IDE:** Android Studio Iguana+  
- **SDK mínimo:** API 21 (Android 5.0 Lollipop)  
- **Componentes UI:** LinearLayout, TextView, EditText, Button, ToggleButton, Spinner  
- **Estilo:** Theme.MaterialComponents.DayNight  

---

## 📂 Estructura del Proyecto

app/
├── java/com/miempresa/usocontrolesv1
│ ├── MainActivity.kt 
│ └── Calculadora.kt 
│ └── Promedio.kt 
│
└── res/layout
├── activity_main.xml 
└── activity_calc.xml
└── activity_promedio.xml

UsoControlesv4/
│
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/miempresa/usocontrolesv1/
│   │   │   │   ├── MainActivity.kt                 # Uso de Controles
│   │   │   │   └── Calculadoray.kt   # Caso A: Calculadora
│   │   │   │   └── Promedio.kt   # Caso B: Promedio
│   │   │   │
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_main.xml                # Layout principal - Caso A
│   │   │   │   │   └── activity_calc.xml                # Layout para cálculo
│   │   │   │   │   └── activity_promedio.xml            # Layout para promedios
│   │   │   │   │
│   │   │   │   │
│   │   │   │   ├── values/
│   │   │   │   │   ├── colors.xml                     # Colores de la app
│   │   │   │   │   ├── strings.xml                    # Textos usados (Mi Primera Aplicación, etc.)
│   │   │   │   │   └── themes.xml                     # Tema de la aplicación
│   │   │   │   │
│   │   │   │   └── mipmap-*/                           # Íconos de la app (launcher)
│   │   │   │
│   │   │   └── AndroidManifest.xml                     # Registro de Activities
│   │   │
│   │   └── test/                                       # (opcional) pruebas unitarias
│   │
│   ├── build.gradle (Module: app)
│   └── proguard-rules.pro
│
├── build.gradle (Project)
├── settings.gradle
└── README.md
---

## 🧩 Casos Desarrollados

### ✅ Caso A – Uso de Controles
Se implementó un formulario sencillo que:
- Muestra un título con estilo (`TextView`).
- Solicita usuario y clave (`EditText`).
- Usa un botón (`Button`) para mostrar un mensaje de bienvenida.
- Usa un `ToggleButton` para indicar acceso habilitado/deshabilitado.
- Muestra el resultado en un `TextView`.

**Capturas de Pantalla:**  


<img width="921" height="656" alt="image" src="https://github.com/user-attachments/assets/e3c7e6db-4d96-4a40-b8f4-4575a7281a33" />


### ✅ Caso B – Promedio Final del Estudiante
Se desarrolló una aplicación que:
1. **Recibe las notas** de 4 exámenes de teoría (toma solo las 3 mejores) y 8 laboratorios.
2. **Calcula el promedio final** según la fórmula:
3. **Verifica si el alumno aprueba o desaprueba**:
   - Si el promedio es menor a 10.5, solicita nota de sustitutorio y recalcula reemplazando la nota más baja.
4. **Permite calcular mínimo 3 alumnos en la misma sesión** y muestra un ranking del mejor al peor promedio.

**Validaciones Incluidas**
- Notas entre 0 y 20.
- Manejo de errores si faltan notas.
- Mensaje de aprobado/desaprobado con indicador visual.

**Capturas de Pantalla:**  
*(inserta aquí tus imágenes de la interfaz, cálculo normal y cálculo con sustitutorio)*

---

## 🚀 Cómo Ejecutar el Proyecto

1. Clonar o descargar el repositorio en tu computadora.
2. Abrir la carpeta en **Android Studio**.
3. Conectar un emulador o dispositivo físico.
4. Ejecutar la aplicación con ▶️ **Run**.

---

## 👀 Observaciones
- El atributo `android:drawableLeft` en el botón permite mostrar un ícono junto al texto.
- El uso de `LinearLayout` vertical facilita la organización de los controles.
- Se usó `ScrollView` en el Caso B para evitar desbordes en pantallas pequeñas.

---

## 📝 Conclusiones
- Comprendí cómo trabajar con `LinearLayout` y manejar eventos en Kotlin.
- El Caso B me ayudó a practicar lógica de negocio, validaciones y ranking de alumnos.
- La app es extensible y puede adaptarse para más alumnos o notas con pocos cambios.

---

## 📸 Capturas Recomendadas para el Informe
- **XML en modo Code y Preview**.
-<img width="1289" height="921" alt="image" src="https://github.com/user-attachments/assets/b9547e12-cbb1-4160-a792-7f1cc78b6f8d" />
-<img width="1291" height="847" alt="image" src="https://github.com/user-attachments/assets/9bade41f-ffbf-4ad6-911b-5d62837823ed" />
-<img width="1367" height="908" alt="image" src="https://github.com/user-attachments/assets/60690433-4fb0-405a-a121-f46b210d9431" />


- **Ejecución en el emulador/dispositivo.**
- <img width="913" height="701" alt="image" src="https://github.com/user-attachments/assets/c168b150-2127-4643-a88a-c4bf09766297" />

- **Resultados de cálculo normal y con sustitutorio.**
- <img width="454" height="857" alt="image" src="https://github.com/user-attachments/assets/3e8915d0-a5bb-49e4-9006-81763540fe33" />
- <img width="474" height="901" alt="image" src="https://github.com/user-attachments/assets/7ee0db1f-d36f-41cd-b579-054a9cdc517f" />


- **Pantalla de ranking final.**
- <img width="584" height="1079" alt="image" src="https://github.com/user-attachments/assets/bea87fb7-e3f5-40e0-92b8-a81359f560d7" />

---

## 👨‍💻 Autor
- **Nombre:** Frank Sinca  
- **Curso:** Programación en Móviles  
- **Instituto:** TECSUP  
- **Docente:** Juan León S.



