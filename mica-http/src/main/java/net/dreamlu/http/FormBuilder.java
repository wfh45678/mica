/*
 * Copyright (c) 2019-2029, Dreamlu (596392912@qq.com & www.dreamlu.net).
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.dreamlu.http;

import okhttp3.FormBody;

/**
 * 表单构造器
 *
 * @author L.cm
 */
public class FormBuilder {
	private final HttpRequest request;
	private final FormBody.Builder formBuilder;

	FormBuilder(HttpRequest request) {
		this.request = request;
		this.formBuilder = new FormBody.Builder();
	}

	public FormBuilder add(String name, String value) {
		this.formBuilder.add(name, value);
		return this;
	}

	public FormBuilder addEncoded(String name, String value) {
		this.formBuilder.addEncoded(name, value);
		return this;
	}

	public HttpRequest build() {
		FormBody formBody = formBuilder.build();
		this.request.form(formBody);
		return this.request;
	}

	public HttpResponse execute() {
		return this.build().execute();
	}
}