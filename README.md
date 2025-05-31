# Spring-Ai
A Spring Boot and React-based GenAI application powered by Ollama LLM, featuring AI chat, recipe generation, and multilingual translation via RESTful APIs.

# TechStack
- Java
- Spring Boot
- React
- Ollama (llama3.2:3b)

# Features
- Chat with AI
- Recipe Generator
- Multilingual Translation

# How to run
The two modules need to be run separately.

## spring-ai-backend

-------------------------------------------------------------------------------------------
### Prerequisites
- Make sure you have Ollama installed locally. You can download it from https://ollama.com.
- Ensure the llama3:3b model is pulled and running. If not, run the following command:
```bash
  ollama run llama3.2:3b
```
-------------------------------------------------------------------------------------------

1. Go inside the spring-ai-backend module and download all the dependencies. 
```bash
  ./gradlew clean build
```
 
2. Run the application

## spring-ai-react
1. Go inside the spring-ai-react module and download all the dependencies.
```bash
  npm install
```

2. Run the application
```bash
  npm start
```
