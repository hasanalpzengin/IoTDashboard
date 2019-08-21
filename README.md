# IoTDashboard Documentation
### Contents
0. Introduction
1. Technologies
2. Structure
3. Data
4. Communication

## 0. Introduction
IoTDashboard project created to track and manage IoT device's dynamically with modern technologies. Small Start-ups and invidual customers are targetted audiences.
It's designed based as 4 chunk. Each chunk can run in same or different servers. So It allows us to distribute system.
## 1. Technologies
Java Spring Boot used in this project. This technologies used to build project.
1. Spring Boot
2. Redis (Database)
3. Thymeleaf (Theme Engine)
4. Websocket (Device 2 Device, Device 2 Server communication)
5. GraphQL (REST Chunk)
6. Vue.JS (Front-end)
## 2. Structure
Project Structure
![System Structure Image](https://hasanalpzengin.com/image/cover_images/1-6a158dd7f1a5a41791b4dc5de9c82189.jpg)
Server Class Structure
*Config
- Cache Properties
- Redis Configuration
- WebSocketConfiguration
*Controller
- IndexController
- DeviceController
- UserController
- SocketController
*Model
- Device
- Group
- Log
- SocketMessage
- User
*Repositories
- DeviceRepository
- UserRepository
*Resolver
- Mutation
- Query
*Service
- DeviceService
- UserService
- ViewHelper
### ToDo
[] Front-end
[] Raspberry Pi Library
[] Ardunio Library

IoT Dashboard project with some modern stuff (Spring, Redis, Websocket, GraphQL, Bootstrap and Vue.JS)
Contact: hasalp38@gmail.com
