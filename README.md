It is a Crowdfunding maven-based project to help startups raise capital. It includes a backstage content management system using single architecture and a membership system using a distributed microservices architecture. 

1.Technique Architecture: 
Front-end: Vue.js, Nuxt, Vue-admin-template, Element-UI, Axios, Node.js, NPM  

Back-end: Spring Boot, Spring Cloud(Nacos, OpenFeign, Sentinel, Gateway), MyBatis Plus, MySQL, Redis, RabbitMQ, Alibaba Cloud(Object Storage Service, Short Message Service), Swagger2

2.Files Structure
srb: Back-end code base
srb-admin: Front-end code base for admin pages
srb-site: Front-end code base for membership system
hfb: Virtual third-party fund custodian code page

3. Technique Details
Spring Boot is used to build microservices including common api module, service-base api, core service, short message service and file storage service. Spring Cloud connects these microservices through Nacos, OpenFeign, Sentinel and Gateway. Nacos serves as services registry center to help discover, configure, and manage the microservices. OpenFeign is used by a service to remotely call another microservice by simple declarative annotations. 

When one service synchronously calls another, there's a possibility that another service can be down for some reason. In such a case, threads are blocked as they keep on waiting for the other service to respond. To prevent such scenarios, Sentinel blocks all subsequent calls immediately and use a fallback method to respond.
