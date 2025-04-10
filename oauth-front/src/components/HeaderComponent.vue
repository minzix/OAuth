<template>
    <v-app-bar app dark>
        <v-container>
            <v-row class="align-center">
                <v-col class="d-flex justify-end">
                    <v-btn v-if="!isLogin" :to="{path: '/member/create'}">
                        회원가입
                    </v-btn>
                    <v-btn v-if="!isLogin" :to="{path: '/member/login'}">
                        로그인
                    </v-btn>
                    <v-btn v-if="isLogin" @click="doLogout()">
                        로그아웃
                    </v-btn>
                </v-col>
            </v-row>
        </v-container>
    </v-app-bar>
</template>

<script>
    export default {
        // 아래의 함수들은 화면이 열리자마자 실행되는 Vue의 Hook 함수들
        data() {
            return {
                isLogin: false,
            };
        },
        created() { // 로그인이 되어 있는지 확인 후, isLogin 상태 업데이트
            if (localStorage.getItem('token')) { // localStorage에 token이 있으면 로그인 상태
                this.isLogin = true;
            } else {
                this.isLogin = false;
            }
        },
        methods: { // 아래의 함수들은 우리가 위의 template에서 명시적으로 호출해야 실행되는 함수들
            doLogout() { // 로그아웃 함수
                localStorage.clear();
                window.location.reload(); // 페이지 새로고침 -> 다시 isLogin이 false로 바뀔 것!
            },
        },
    };
</script>