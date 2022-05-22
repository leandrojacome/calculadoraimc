FROM node:12.22.12-buster-slim as build-stage

WORKDIR /usr/src/app

COPY package*.json ./
RUN npm install --verbose

COPY . .

EXPOSE 4200
ENTRYPOINT [ "npm", "run", "start" ]
# RUN npm run build

# FROM nginx:stable as web-stage

# USER root

# COPY --from=build-stage /usr/src/app/dist /var/www
# COPY --from=build-stage /usr/src/app/server/nginx.conf /etc/nginx/nginx.conf

# EXPOSE 80
# ENTRYPOINT ["nginx","-g","daemon off;"]
