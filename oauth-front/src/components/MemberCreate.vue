<template>
    <v-container
        fluid
        class="d-flex align-center justify-center"
        style="height: 100vh;"
    >
        <v-row justify="center">
            <v-col md="6">
                <v-card-title class="text-h5">
                    회원가입
                </v-card-title>
                <v-card-text>
                    <v-form>
                        <v-text-field
                            label="email"
                            v-model="email"
                        >
                        </v-text-field>
                        <v-text-field
                            label="password"
                            v-model="password"
                            type="password"
                        >
                        </v-text-field>
                        <v-btn
                            type="button"
                            color="primary"
                            block @click="memberCreate()"
                        >
                            등록
                        </v-btn>
                    </v-form>
                </v-card-text>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>
import axios from 'axios';

    export default {
        data() {
            return {
                email: '',
                password: '',
            };
        },
        methods: {
            async memberCreate() {
                const url = 'http://localhost:8080/member/create';
                const data = { // JSON 형태로 반환됨
                    email: this.email,
                    password: this.password,
                };
                await axios.post(url, data); // 비동기 요청이므로 await async 사용
                window.location.href = '/'; 
            },
        },
    };
</script>