(function(e){function t(t){for(var n,i,o=t[0],c=t[1],l=t[2],u=0,p=[];u<o.length;u++)i=o[u],Object.prototype.hasOwnProperty.call(s,i)&&s[i]&&p.push(s[i][0]),s[i]=0;for(n in c)Object.prototype.hasOwnProperty.call(c,n)&&(e[n]=c[n]);d&&d(t);while(p.length)p.shift()();return r.push.apply(r,l||[]),a()}function a(){for(var e,t=0;t<r.length;t++){for(var a=r[t],n=!0,o=1;o<a.length;o++){var c=a[o];0!==s[c]&&(n=!1)}n&&(r.splice(t--,1),e=i(i.s=a[0]))}return e}var n={},s={app:0},r=[];function i(t){if(n[t])return n[t].exports;var a=n[t]={i:t,l:!1,exports:{}};return e[t].call(a.exports,a,a.exports,i),a.l=!0,a.exports}i.m=e,i.c=n,i.d=function(e,t,a){i.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:a})},i.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},i.t=function(e,t){if(1&t&&(e=i(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var a=Object.create(null);if(i.r(a),Object.defineProperty(a,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var n in e)i.d(a,n,function(t){return e[t]}.bind(null,n));return a},i.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return i.d(t,"a",t),t},i.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},i.p="/";var o=window["webpackJsonp"]=window["webpackJsonp"]||[],c=o.push.bind(o);o.push=t,o=o.slice();for(var l=0;l<o.length;l++)t(o[l]);var d=c;r.push([0,"chunk-vendors"]),a()})({0:function(e,t,a){e.exports=a("56d7")},"010c":function(e,t,a){},"034f":function(e,t,a){"use strict";a("85ec")},"47b0":function(e,t,a){"use strict";a("d2c9")},"56d7":function(e,t,a){"use strict";a.r(t);a("e260"),a("e6cf"),a("cca6"),a("a79d");var n=a("2b0e"),s=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("v-app",[a("Navbar",{attrs:{paths:e.paths}}),a("router-view")],1)},r=[],i=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("v-toolbar",{attrs:{flat:"",color:"transparent"}},[a("v-tabs",e._l(e.paths,(function(t,n){return a("v-tab",{key:n,attrs:{link:"",to:t.url}},[e._v(e._s(t.name))])})),1)],1)],1)},o=[],c={props:{paths:{type:Array,required:!0}}},l=c,d=a("2877"),u=a("6544"),p=a.n(u),m=a("71a3"),f=a("fe57"),h=a("71d9"),v=Object(d["a"])(l,i,o,!1,null,null,null),b=v.exports;p()(v,{VTab:m["a"],VTabs:f["a"],VToolbar:h["a"]});var g={components:{Navbar:b},data:function(){return{paths:[{name:"Home",url:"/"},{name:"Meus Dados",url:"/forms"},{name:"Meu Painel",url:"/panel"}]}}},C=g,y=(a("034f"),a("7496")),x=Object(d["a"])(C,s,r,!1,null,null,null),D=x.exports;p()(x,{VApp:y["a"]});var w=a("8c4f"),_=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("section",{staticClass:"main-container"},[n("v-row",{staticClass:"main-row",attrs:{align:"end"}},[n("v-col",{staticClass:"usp-logo",attrs:{cols:"3"}},[n("img",{staticClass:"logo-usp",attrs:{src:a("60e1"),alt:"Logo USP"}})]),n("v-col",{attrs:{cols:"9"}},[n("div",{staticClass:"text"},[n("h1",[e._v("Recomendador de Disciplinas")]),n("v-divider"),n("h2",[e._v("Facilitando seu caminho")])],1)])],1),n("v-row",{staticClass:"btn-row",attrs:{justify:"center",align:"center"}},[n("v-btn",{staticClass:"px-10 py-7 rounded-lg",attrs:{color:"#E7D2CC",depressed:"",to:"/forms"}},[e._v("Começar")])],1)],1)},k=[],R={name:"Home"},V=R,O=(a("c757"),a("8336")),j=a("62ad"),S=a("ce7e"),E=a("0fd9"),L=Object(d["a"])(V,_,k,!1,null,"0bdfc5f6",null),A=L.exports;p()(L,{VBtn:O["a"],VCol:j["a"],VDivider:S["a"],VRow:E["a"]});var I=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("v-container",[a("v-form",{ref:"form"},[a("v-row",[a("v-col",{attrs:{align:"center"}},[a("h1",{staticClass:"text-h5"},[e._v("Seja Bem Vindo(a)!")]),a("p",{staticClass:"subtitle"},[e._v("Forneça alguns dados inciais para começarmos")])])],1),e._l(e.errors,(function(t){return a("v-row",{key:t},[a("v-col",{staticClass:"pa-0"},[a("v-alert",{attrs:{type:"error"}},[e._v(" "+e._s(t)+" ")])],1)],1)})),a("v-row",[a("v-col",[a("h2",{staticClass:"text-h6"},[e._v("Dados pessoais")]),a("v-divider",{staticClass:"divider"})],1)],1),a("v-row",{staticClass:"px-10"},[a("v-col",[a("v-text-field",{attrs:{label:"Nome",required:"",clearable:""},model:{value:e.userData.name,callback:function(t){e.$set(e.userData,"name",t)},expression:"userData.name"}}),a("v-autocomplete",{attrs:{items:e.backendData.allCoursesCode,label:"Código do curso","no-data-text":"Nenhum código de curso encontrado",hint:"Exemplo: o código de Ciência da Computação no IME-USP é 45052. Caso não lembre o código do seu curso, acesse o JupiterWeb.","persistent-hint":"",clearable:""},model:{value:e.userData.courseCode,callback:function(t){e.$set(e.userData,"courseCode",t)},expression:"userData.courseCode"}}),a("v-autocomplete",{attrs:{items:e.displayDisciplines,label:"Disciplinas já\n        cursadas","no-data-text":"Nenhuma disciplina encontrada",clearable:"","open-on-clear":""},on:{change:e.addDiscipline},model:{value:e.discipline,callback:function(t){e.discipline=t},expression:"discipline"}})],1),a("v-col",[a("Board",{attrs:{disciplines:e.userData.disciplines},on:{erase:e.eraseDiscipline}})],1)],1),a("v-row",[a("v-col",[a("h2",{staticClass:"text-h6"},[e._v("Interesses")]),a("v-divider",{staticClass:"divider"})],1)],1),a("v-row",{staticClass:"px-10"},[a("v-col",[a("v-combobox",{staticClass:"mb-5",attrs:{label:"Tópicos de interesse",hint:"Caso deseje usar expressões regulares, utilize '/' no início e no fim de uma palavra-chave. Exemplo: '/computa+/'","persistent-hint":"","deletable-chips":"",multiple:"","small-chips":""},model:{value:e.userData.keywords,callback:function(t){e.$set(e.userData,"keywords",t)},expression:"userData.keywords"}}),a("v-autocomplete",{attrs:{label:"Departamentos de interesse",items:e.displayDepartments,"no-data-text":"Nenhum departamento encontrado","deletable-chips":"",multiple:"","small-chips":""},model:{value:e.userData.departments,callback:function(t){e.$set(e.userData,"departments",t)},expression:"userData.departments"}})],1)],1),a("v-row",{attrs:{justify:"center"}},[a("v-btn",{staticClass:"px-10 mt-8 py-7 rounded-lg",attrs:{color:"#CEE7CC",depressed:""},on:{click:e.submit}},[e._v("Salvar")])],1)],2)],1)},N=[],P=a("1da1"),T=(a("96cf"),a("4e827"),a("4de4"),a("7db0"),a("d81d"),a("99af"),a("b0c0"),function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("v-sheet",{staticClass:"d-flex justify-center flex-wrap pa-5 board rounded-xl"},[e.disciplines.length>0?e._l(e.disciplines,(function(t,n){return a("Card",{key:n,attrs:{discipline:t},on:{erase:e.erase}})})):a("v-row",{staticClass:"pa-5"},[a("v-col",{attrs:{align:"center"}},[a("span",{staticClass:"font-weight-medium text--disabled"},[e._v("Selecione uma disciplina")])])],1)],2),a("p",{staticClass:"text-center"},[e._v(e._s(e.captionText))])],1)}),M=[],$=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("v-sheet",{staticClass:"ma-2",attrs:{color:"#E7D2CC",elevation:"1",width:"fit-content",height:"fit-content"}},[a("v-container",{staticClass:"align-center"},[a("v-row",[a("v-col",{staticClass:"pa-0 mb-2",attrs:{align:"end"}},[a("v-icon",{attrs:{dense:"",color:"red"},on:{click:e.eraseCard}},[e._v(" mdi-close ")])],1)],1),a("p",{staticClass:"ma-0 text-center text-h5"},[e._v(e._s(e.departmentCode))]),a("p",{staticClass:"ma-0 text-center"},[e._v(e._s(e.disciplineCode))])],1)],1)},B=[],J=(a("ac1f"),a("466d"),{props:{discipline:String},computed:{departmentCode:function(){var e=/\D+/;return this.discipline.match(e)[0]},disciplineCode:function(){var e=/\d+/;return this.discipline.match(e)[0]}},methods:{eraseCard:function(){this.$emit("erase",this.discipline)}}}),q=J,F=a("a523"),U=a("132d"),H=a("8dd9"),W=Object(d["a"])(q,$,B,!1,null,null,null),z=W.exports;p()(W,{VCol:j["a"],VContainer:F["a"],VIcon:U["a"],VRow:E["a"],VSheet:H["a"]});var G={props:{disciplines:Array},components:{Card:z},computed:{captionText:function(){var e="Disciplinas selecionadas";return 1==this.disciplines.length&&(e="Disciplina selecionada"),this.disciplines.length+" "+e}},methods:{erase:function(e){this.$emit("erase",e)}}},K=G,Q=(a("bb7b"),Object(d["a"])(K,T,M,!1,null,"3b18a7be",null)),X=Q.exports;p()(Q,{VCol:j["a"],VRow:E["a"],VSheet:H["a"]});var Y=a("3835");a("159b"),a("b64b"),a("1276"),a("498a");function Z(e){return{name:JSON.parse(e.getItem("name"))||"",disciplines:JSON.parse(e.getItem("disciplines"))||[],departments:JSON.parse(e.getItem("departments"))||[],keywords:JSON.parse(e.getItem("keywords"))||[],courseCode:JSON.parse(e.getItem("courseCode"))||""}}function ee(e){return{name:JSON.parse(e.getItem("name"))||"",keywords:JSON.parse(e.getItem("keywords"))||[],courseCode:JSON.parse(e.getItem("courseCode"))||"",disciplines:ae(JSON.parse(e.getItem("disciplines")))||[],departments:ae(JSON.parse(e.getItem("departments")))||[]}}function te(e,t){var a=t.userData,n=t.backendData,s=a.name,r=a.courseCode,i=a.disciplines,o=a.departments,c=a.keywords,l=n.allDepartments,d=n.allDisciplines;e.clear();var u=ne(l,o),p=ne(d,i),m={name:s,courseCode:r,disciplines:p,departments:u,keywords:c};Object.keys(m).forEach((function(t){e.setItem(t,JSON.stringify(m[t]))}))}function ae(e){return null===e||void 0===e?void 0:e.map((function(e){return"".concat(e.code," - ").concat(e.name)}))}function ne(e,t){return t.map((function(t){return e.find((function(e){var a=e.code,n=t.split("-"),s=Object(Y["a"])(n,1),r=s[0];return r.trim()==a}))}))}function se(e,t){var a=e.name,n=e.courseCode,s=e.departments,r=e.keywords,i=[];return a.trim()||i.push("É necessário informar seu nome"),t.find((function(e){return e===n}))||i.push("Código do curso não existe"),0===s.length&&i.push("É necessário informar ao menos um departamento de interesse"),0===r.length&&i.push("É necessário informar ao menos um tópico de interesse"),{isValid:0===i.length,errors:i}}a("d3b7"),a("3ca3"),a("ddb0"),a("9861");var re=a("bc3a"),ie=a.n(re),oe=ie.a.create({baseURL:Object({NODE_ENV:"production",BASE_URL:"/"}).BACKEND_URL||"http://localhost:8080"}),ce=oe;function le(e){return de.apply(this,arguments)}function de(){return de=Object(P["a"])(regeneratorRuntime.mark((function e(t){var a,n,s,r=arguments;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return a=r.length>1&&void 0!==r[1]?r[1]:{},n=new URLSearchParams,Object.keys(a).forEach((function(e){n.append(e,a[e])})),e.next=5,ce.get(t,{params:n});case 5:if(s=e.sent,200!==s.status){e.next=8;break}return e.abrupt("return",s.data);case 8:return e.abrupt("return",null);case 9:case"end":return e.stop()}}),e)}))),de.apply(this,arguments)}var ue={data:function(){return{userData:{name:"",disciplines:[],departments:[],keywords:[],recommendations:[],courseCode:""},backendData:{allCoursesCode:[],allDisciplines:[],allDepartments:[]},discipline:"",errors:[]}},components:{Board:X},mounted:function(){this.userData=ee(localStorage),this.fetchBackendData()},methods:{fetchBackendData:function(){var e=this;return Object(P["a"])(regeneratorRuntime.mark((function t(){var a,n,s,r;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,le("/disciplines");case 2:if(t.t0=t.sent,t.t0){t.next=5;break}t.t0=[];case 5:return n=t.t0,t.next=8,le("/departments");case 8:if(t.t1=t.sent,t.t1){t.next=11;break}t.t1=[];case 11:return s=t.t1,t.next=14,le("/requisites/courses");case 14:if(t.t4=a=t.sent,t.t3=null===t.t4,t.t3){t.next=18;break}t.t3=void 0===a;case 18:if(!t.t3){t.next=22;break}t.t5=void 0,t.next=23;break;case 22:t.t5=a.sort();case 23:if(t.t2=t.t5,t.t2){t.next=26;break}t.t2=[];case 26:r=t.t2,e.backendData={allDisciplines:n,allDepartments:s,allCoursesCode:r};case 28:case"end":return t.stop()}}),t)})))()},eraseDiscipline:function(e){this.userData.disciplines=this.userData.disciplines.filter((function(t){return e!=t}))},addDiscipline:function(){var e=this,t=this.userData.disciplines.find((function(t){return t==e.discipline}));if(!t){var a=this.displayDisciplines.find((function(t){return t==e.discipline}));a&&(this.userData.disciplines.push(this.discipline),this.discipline="")}},submit:function(){var e=se(this.userData,this.backendData.allCoursesCode),t=e.isValid,a=e.errors;t?(te(localStorage,{userData:this.userData,backendData:this.backendData}),this.$router.push("/panel")):this.errors=a}},computed:{displayDisciplines:function(){return this.backendData.allDisciplines.map((function(e){return"".concat(e.code," - ").concat(e.name)}))},displayDepartments:function(){return this.backendData.allDepartments.map((function(e){return"".concat(e.code," - ").concat(e.name)}))}}},pe=ue,me=(a("6a42"),a("0798")),fe=a("c6a6"),he=a("2b5d"),ve=a("4bd4"),be=a("8654"),ge=Object(d["a"])(pe,I,N,!1,null,"9144be60",null),Ce=ge.exports;p()(ge,{VAlert:me["a"],VAutocomplete:fe["a"],VBtn:O["a"],VCol:j["a"],VCombobox:he["a"],VContainer:F["a"],VDivider:S["a"],VForm:ve["a"],VRow:E["a"],VTextField:be["a"]});var ye=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("v-container",{class:e.panelContainerClass},[e.checkIfUserHasNotData?a("v-container",{staticClass:"d-flex flex-column align-self-center align-center"},[a("h1",{staticClass:"text-center"},[e._v(" Preencha seus dados para visualizar o painel :) ")]),a("v-btn",{staticClass:"mt-8 py-7 rounded-lg",attrs:{color:"#CEE7CC",depressed:"",width:"50%",to:"/forms"}},[e._v("Preencher agora")])],1):a("div",[a("v-row",{staticClass:"my-4"},[a("v-col",[a("h1",{staticClass:"mx-2 mb-1 font-weight-regular text-h4"},[e._v(" "+e._s(e.userData.name)+" ")]),a("div",[a("p",{staticClass:"mx-2 mb-0 text--secondary text-subtitle"},[e._v(" Código do curso: "+e._s(e.userData.courseCode)+" ")]),a("p",{staticClass:"mx-2 mb-0 text--secondary text-subtitle"},[e._v(" Topicos de interesse: "+e._s(e.displayKeywords)+" ")]),a("p",{staticClass:"mx-2 mb-0 text--secondary text-subtitle"},[e._v(" Departamentos de interesse: "+e._s(e.displayDepartments)+" ")])])]),a("v-col",[a("v-container",{staticClass:"d-flex flex-column justify-space-between align-end"},[a("v-btn",{staticClass:"my-1 px-5 py-2 small rounded-lg",attrs:{color:"#FAF7B1",depressed:"",width:"50%"},on:{click:e.reactButtons}},[a("v-icon",{attrs:{left:""}},[e._v(" mdi-pencil ")]),e._v("Editar Dados")],1),a("v-btn",{staticClass:"my-1 px-5 py-2 small rounded-lg",attrs:{color:"#FAF7B1",depressed:"",width:"50%"},on:{click:e.reactButtons}},[a("v-icon",{attrs:{left:""}},[e._v(" mdi-pencil ")]),e._v("Editar Interesses")],1)],1)],1)],1),a("v-row",{attrs:{justify:"center"}},[e.dataFetched?a("Tabs",{attrs:{disciplines:e.displayDisciplines,recommendations:e.displayRecommendations,possibleRecommendations:e.possibleRecommendations}}):a("v-progress-circular",{attrs:{size:200,width:20,color:"blue",indeterminate:""}},[e._v("Loading")])],1)],1)],1)},xe=[],De=(a("a15b"),function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"tabs-container"},[a("v-tabs",{staticClass:"mb-3",attrs:{"background-color":"transparent",grow:""},model:{value:e.tab,callback:function(t){e.tab=t},expression:"tab"}},[a("v-tab",{key:"table"},[e._v("Tabela")]),a("v-tab",{key:"graph"},[e._v("Grafo")]),a("v-tab",{key:"cloud"},[e._v("Nuvem de palavras")])],1),a("v-tabs-items",{staticClass:"transparent",model:{value:e.tab,callback:function(t){e.tab=t},expression:"tab"}},[a("v-tab-item",{key:"table"},[a("Table",{attrs:{disciplines:e.disciplines,recommendations:e.recommendations}})],1),a("v-tab-item",{key:"graph"},[a("Graph",{attrs:{possibleRecommendations:e.possibleRecommendations}})],1),a("v-tab-item",{key:"cloud"},[a("WordCloud",{attrs:{disciplines:e.disciplines,recommendations:e.recommendations}})],1)],1)],1)}),we=[],_e=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("v-row",{staticClass:"transparent"},[a("v-col",{staticClass:"border mx-2 d-flex flex-column rounded-lg"},[a("h2",{staticClass:"mb-4"},[e._v("Disciplinas cursadas")]),e._l(e.disciplines,(function(t,n){return a("v-chip",{key:n,staticClass:"mb-2"},[e._v(" "+e._s(t)+" ")])}))],2),a("v-col",{staticClass:"border mx-2 d-flex flex-column rounded-lg"},[a("h2",{staticClass:"mb-4"},[e._v("Disciplinas Recomendadas")]),e._l(e.recommendations,(function(t,n){return a("v-chip",{key:n,staticClass:"mb-2"},[e._v(" "+e._s(t)+" ")])}))],2)],1)},ke=[],Re={props:{disciplines:{type:Array,required:!0},recommendations:{type:Array,required:!0}}},Ve=Re,Oe=a("cc20"),je=Object(d["a"])(Ve,_e,ke,!1,null,null,null),Se=je.exports;p()(je,{VChip:Oe["a"],VCol:j["a"],VRow:E["a"]});var Ee=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("v-container",{staticClass:"graph-container align-center d-flex flex-column",attrs:{fluid:""}},[a("h2",{staticClass:"my-5 text-center"},[e._v(" Disciplinas recomendadas disponíveis para serem feitas ")]),a("div",{staticClass:"light-border",attrs:{id:"graph"}}),a("div",{staticClass:"\n      mt-1\n      d-flex\n      flex-column\n      justify-center\n      align-center\n      light-border\n      legend-size\n    "},[a("h2",{staticClass:"text-center mt-3"},[e._v("Legenda")]),a("div",{staticClass:"my-5 d-flex"},[a("span",{staticClass:"border rounded-circle pa-4 mx-2 approved-green"},[e._v("Aprovada")]),a("span",{staticClass:"border rounded-circle pa-4 mx-2 white"},[e._v("Disponível")])])])])},Le=[],Ae=(a("cb29"),a("de47"));function Ie(e){var t=e.data,a=e.width,n=e.height,s=e.container,r=Object(Ae["a"])()(s);r.width(a).height(n).graphData(t).nodeCanvasObject((function(e,t){t.beginPath(),t.fillStyle=null==e.url?"#CEE7CC":"#ffffff",t.arc(e.x,e.y,3,0,2*Math.PI,!1),t.stroke(),t.lineWidth=.5,t.fill(),t.fillStyle="black",t.font="3px 'Montserrat'",t.textAlign="center",t.textBaseline="middle",t.fillText(e.code,e.x,e.y+6)})).dagMode("radialin").dagLevelDistance(13).linkDirectionalArrowLength(6).linkDirectionalArrowRelPos(1).zoom(5).onNodeClick((function(e){var t=e.url;return null!=t&&window.open(t,"_blank")}))}var Ne={props:{possibleRecommendations:{type:Object,required:!0}},mounted:function(){var e=document.getElementById("graph");Ie({data:this.possibleRecommendations,width:e.clientWidth,height:e.clientHeight,container:e})}},Pe=Ne,Te=(a("625b"),Object(d["a"])(Pe,Ee,Le,!1,null,"1e708280",null)),Me=Te.exports;p()(Te,{VContainer:F["a"]});var $e=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("v-row",{staticClass:"transparent"},[a("v-col",{staticClass:"border mx-2 d-flex flex-column rounded-lg",attrs:{align:"center"}},[a("h2",{staticClass:"mb-4"},[e._v("Disciplinas cursadas")]),e.hasLoadedDisciplinesAlreadyDone?e._e():a("v-progress-linear",{attrs:{value:e.percentageLoadedDisciplinesAlreadyDone,striped:"",height:"25",rounded:""}},[a("strong",[e._v(e._s(Math.ceil(e.percentageLoadedDisciplinesAlreadyDone))+"%")])]),a("VueWordCloud",{staticClass:"mx-auto",staticStyle:{height:"50vh",width:"70vw"},attrs:{spacing:1,words:e.disciplinesAlreadyDone,color:e.randomColor,"rotation-unit":"rad",rotation:e.randomRotation,"font-family":"Londrina Sketch"},on:{"update:progress":function(t){return e.updateLoading(t,"disciplines")}},scopedSlots:e._u([{key:"default",fn:function(t){var n=t.text,s=t.weight;return[a("div",{staticClass:"text-h5",staticStyle:{cursor:"pointer"},attrs:{title:n+" ("+s+")"}},[e._v(" "+e._s(n)+" ")])]}}])}),a("h2",{staticClass:"mt-4"},[e._v("Disciplinas Recomendadas")]),e.hasLoadedRecommendations?e._e():a("v-progress-linear",{attrs:{value:e.percentageLoadedRecommendations,striped:"",height:"25",rounded:""}},[a("strong",[e._v(e._s(Math.ceil(e.percentageLoadedRecommendations))+"%")])]),a("VueWordCloud",{staticClass:"mx-auto",staticStyle:{height:"100vh",width:"70vw"},attrs:{spacing:1,words:e.allRecommendations,color:e.randomColor,"font-family":"Londrina Sketch"},on:{"update:progress":function(t){return e.updateLoading(t,"recommendations")}},scopedSlots:e._u([{key:"default",fn:function(t){var n=t.text,s=t.weight;return[a("div",{class:s>1?"text-h6":"caption",staticStyle:{cursor:"pointer"},attrs:{title:n+" ("+s+")"}},[e._v(" "+e._s(n)+" ")])]}}])})],1)],1)},Be=[],Je=(a("4ec9"),a("a630"),{props:{disciplines:{type:Array,required:!0},recommendations:{type:Array,required:!0}},data:function(){return{percentageLoadedRecommendations:0,percentageLoadedDisciplinesAlreadyDone:0,colors:["#f94144","#f3722c","#f8961e","#f9844a","#90be6d","#43aa8b","#4d908e","#577590","#277da1"],rotations:[0,7/8,3/4,1/8]}},computed:{allRecommendations:function(){var e=new Map,t=this.recommendations.map((function(e){return e.split("-")[1].trim()}));return t.forEach((function(t){var a=e.get(t);e.set(t,a?a+1:1)})),Array.from(e.keys()).map((function(t){return[t,e.get(t)]}))},disciplinesAlreadyDone:function(){return this.disciplines.map((function(e){var t=e.split("-")[1];return[t.trim(),1]}))},hasLoadedRecommendations:function(){return this.percentageLoadedRecommendations>=100},hasLoadedDisciplinesAlreadyDone:function(){return this.percentageLoadedDisciplinesAlreadyDone>=100}},methods:{randomColor:function(){var e=this.colors.length,t=Math.floor(Math.random()*e);return this.colors[t]},randomRotation:function(){var e=this.rotations.length,t=Math.floor(Math.random()*e);return this.rotations[t]},updateLoading:function(e,t){var a;if(null===e)a=100;else{var n=e.completedWords,s=e.totalWords;a=n/s*100}"recommendations"===t?this.updateLoadedRecommendations(a):this.updateLoadedDisciplinesAlreadyDone(a)},updateLoadedRecommendations:function(e){this.percentageLoadedRecommendations=e},updateLoadedDisciplinesAlreadyDone:function(e){this.percentageLoadedDisciplinesAlreadyDone=e}}}),qe=Je,Fe=a("8e36"),Ue=Object(d["a"])(qe,$e,Be,!1,null,null,null),He=Ue.exports;p()(Ue,{VCol:j["a"],VProgressLinear:Fe["a"],VRow:E["a"]});var We={components:{Table:Se,Graph:Me,WordCloud:He},props:{disciplines:{type:Array,required:!0},recommendations:{type:Array,required:!0},possibleRecommendations:{type:Object,required:!0}},data:function(){return{tab:null}}},ze=We,Ge=(a("47b0"),a("c671")),Ke=a("aac8"),Qe=Object(d["a"])(ze,De,we,!1,null,null,null),Xe=Qe.exports;function Ye(e){var t=new Map,a={nodes:[],links:[]};return e.forEach((function(e){var n,s=e.code,r=e.name,i=e.url,o=e.requisites,c=null===(n=o[0])||void 0===n?void 0:n.requisites,l=a.nodes.length+1;a.nodes.push({id:l,name:"".concat(s," - ").concat(r),code:s,url:i}),null===c||void 0===c||c.forEach((function(e){var n,s=e.discipline,r=s.split("-").map((function(e){return e.trim()})),i=Object(Y["a"])(r,2),o=i[0];i[1];t.has(o)?n=t.get(o):(n=a.nodes.length+1,t.set(o,n),a.nodes.push({id:n,name:s,code:o,url:null})),a.links.push({source:n,target:l})}))})),a}p()(Qe,{VTab:m["a"],VTabItem:Ge["a"],VTabs:f["a"],VTabsItems:Ke["a"]});var Ze={components:{Tabs:Xe},data:function(){return{userData:{name:"",disciplines:[],departments:[],keywords:[],recommendations:[],courseCode:""},recommendations:[],dataFetched:!1,possibleRecommendations:{}}},mounted:function(){this.loadUserData(),this.checkIfUserHasNotData||this.fetch()},computed:{checkIfUserHasNotData:function(){return""==this.userData.name},panelContainerClass:function(){var e="height-100";return this.checkIfUserHasNotData&&(e+=" d-flex"),e},displayDisciplines:function(){return this.userData.disciplines.map((function(e){return"".concat(e.code," - ").concat(e.name)}))},displayDepartments:function(){return this.userData.departments.map((function(e){return e.code})).join(", ")},displayKeywords:function(){return this.userData.keywords.join(", ")},displayRecommendations:function(){return this.recommendations.map((function(e){return"".concat(e.code," - ").concat(e.name)}))}},methods:{loadUserData:function(){this.userData=Z(localStorage)},fetchRecommendations:function(){var e=this;return Object(P["a"])(regeneratorRuntime.mark((function t(){var a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return a={departmentsId:e.userData.departments.map((function(e){return e.id})),disciplinesCode:e.userData.disciplines.map((function(e){return e.code})),keywords:e.userData.keywords},t.next=3,le("/disciplines/recommendations",a);case 3:e.recommendations=t.sent;case 4:case"end":return t.stop()}}),t)})))()},fetchPossibleRecommendations:function(){var e=this;return Object(P["a"])(regeneratorRuntime.mark((function t(){var a,n;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return a={disciplinesCode:e.userData.disciplines.map((function(e){return e.code})),departmentsId:e.userData.departments.map((function(e){return e.id})),keywords:e.userData.keywords,courseCode:e.userData.courseCode},t.next=3,le("/disciplines/possible-recommendations",a);case 3:n=t.sent,e.possibleRecommendations=Ye(n);case 5:case"end":return t.stop()}}),t)})))()},fetch:function(){var e=this;return Object(P["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return e.dataFetched=!1,t.next=3,e.fetchRecommendations();case 3:return t.next=5,e.fetchPossibleRecommendations();case 5:e.dataFetched=!0;case 6:case"end":return t.stop()}}),t)})))()},reactButtons:function(){alert('Em construção. Utilize a aba "Meus Dados" para editar seus dados.')}}},et=Ze,tt=(a("d890"),a("490a")),at=Object(d["a"])(et,ye,xe,!1,null,"b5f62b42",null),nt=at.exports;p()(at,{VBtn:O["a"],VCol:j["a"],VContainer:F["a"],VIcon:U["a"],VProgressCircular:tt["a"],VRow:E["a"]}),n["a"].use(w["a"]);var st=[{path:"/",name:"Home",component:A},{path:"/forms",name:"Forms",component:Ce},{path:"/panel",name:"Panel",component:nt},{path:"/*",redirect:{name:"Home"}}],rt=new w["a"]({mode:"history",routes:st}),it=rt,ot=a("f309"),ct={};n["a"].use(ot["a"]);var lt=new ot["a"](ct),dt=a("2d8a"),ut=a.n(dt);n["a"].component(ut.a.name,ut.a),n["a"].config.productionTip=!1,new n["a"]({router:it,vuetify:lt,render:function(e){return e(D)}}).$mount("#app")},"60e1":function(e,t,a){e.exports=a.p+"img/usp-logo-transp.462b6d02.png"},"625b":function(e,t,a){"use strict";a("801c")},"6a42":function(e,t,a){"use strict";a("dfed")},"801c":function(e,t,a){},"85ec":function(e,t,a){},bb7b:function(e,t,a){"use strict";a("010c")},c0dc:function(e,t,a){},c757:function(e,t,a){"use strict";a("c0dc")},d2c9:function(e,t,a){},d890:function(e,t,a){"use strict";a("f977")},dfed:function(e,t,a){},f977:function(e,t,a){}});
//# sourceMappingURL=app.993d761c.js.map