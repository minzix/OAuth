  <template>
    <v-container
      fluid
      class="d-flex align-center justify-center"
      style="height: 100vh;"
    >
      <v-row justify="center">
        <v-col cols="12" md="4">
          <v-sheet elevation="3" rounded class="pa-6">
            <v-card-title class="text-h5">로그인</v-card-title>
            <v-card-text>
              <v-form>
                <v-text-field label="email" v-model="email" />
                <v-text-field
                  label="password"
                  type="password"
                  v-model="password"
                />
  
                <v-btn
                  type="button"
                  color="primary"
                  block
                  class="mb-3 elevation-2"
                  @click="memberLogin()"
                >
                  로그인
                </v-btn>
              </v-form>
  
              <v-btn
                block
                class="mb-3 elevation-2 no-hover pa-0"
                style="box-shadow: 0px 2px 6px rgba(0, 0, 0, 0.15);"
                @click="googleLogin()"
              >
                <img
                  src="../assets/google_button.png"
                  style="width: 100%; max-height: 25px; object-fit: contain; display: block;"
                />
              </v-btn>
  
              <v-btn
                block
                class="kakao-btn mb-3 elevation-2 no-hover pa-0"
                style="box-shadow: 0px 2px 6px rgba(0, 0, 0, 0.15); background-color: #fae100;"
                @click="kakaoLogin()"
              >
                <img
                  src="../assets/image.png"
                  style="width: 100%; max-height: 25px; object-fit: contain; display: block;"
                />
              </v-btn>
            </v-card-text>
          </v-sheet>
        </v-col>
      </v-row>
    </v-container>
  </template>
  
  <style scoped>
  .kakao-btn:hover {
    background-color: #fae100;
  }
  </style>
  
  
  
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
            async memberLogin() {
                const url = 'http://localhost:8080/member/do-login';
                const data = { // JSON 형태로 반환됨
                    email: this.email,
                    password: this.password,
                };
                const response = await axios.post(url, data); // 비동기 요청이므로 await async 사용
                const token = response.data.token; // 서버에서 받은 token
                localStorage.setItem('token', token); // localStorage에 token 저장
                window.location.href = '/'; 
            },
            googleLogin() {

            },
            kakaoLogin() {

            },
        },
    };
</script>